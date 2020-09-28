package cs523.finalproject.spark;


import java.sql.Timestamp;
import java.util.*;

import org.apache.spark.SparkConf;
import org.apache.spark.TaskContext;
import org.apache.spark.api.java.*;
import org.apache.spark.api.java.function.*;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.*;
import org.apache.spark.streaming.kafka010.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import cs523.finalproject.kafka.MyValueDeserializer;
import cs523.finalproject.kafka.model.StockInfo;
import cs523.finalproject.kafka.model.StockInfoDTO;
import scala.Tuple2;



public class StockSparkStreaming
{
	public static void main(String[] args) throws Exception
	{
		    String brokers = "quickstart.cloudera:9092";//args[0];
		    String groupId = "console-consumer-34473";//args[1];
		    String hdfsURL = "hdfs://quickstart.cloudera";
		    
		    String topics = "AAPLTest";//args[2];
		    String ticker = "APPL";
		    String hiveFolder = "/user/hive/BDT/StockDaily";
		    int duration = 30;//10 seconds by default
			 int b = 1;
			 
		    
		    if (args.length>=1)
		    	topics = args[0].toString();      
		 	  
		    if (args.length>=2)
		    	ticker = args[1].toString();      

		    if (args.length >=3)
		    	  duration = Integer.parseInt(args[2].toString());	     

		    if (args.length>=4)
		    	hiveFolder = args[3].toString();      
		    
		    String hiveHDFSFolder = hdfsURL+hiveFolder+"/symbol="+ticker+"/loadTime=";

		    // Create context with a 2 seconds batch interval		    

			JavaSparkContext sparkConf = new JavaSparkContext(new SparkConf().setAppName("BDT-KafkaSparkStreaming").setMaster("local[2]"));

		    sparkConf.hadoopConfiguration().set("mapreduce.fileoutputcommitter.marksuccessfuljobs", "false");
		    
		    JavaStreamingContext jssc = new JavaStreamingContext(sparkConf, Durations.seconds(duration));

		    Set<String> topicsSet = new HashSet<>(Arrays.asList(topics.split(",")));
		    Map<String, Object> kafkaParams = new HashMap<>();
		    kafkaParams.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
		    kafkaParams.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		    kafkaParams.put("auto.offset.reset", "latest");
		    kafkaParams.put("enable.auto.commit", "true");
		    kafkaParams.put("auto.commit.interval.ms", "1000");
		    kafkaParams.put("session.timeout.ms", "30000");
		    
		    kafkaParams.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class);
		    kafkaParams.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, MyValueDeserializer.class);

		    TopicPartition partition = new TopicPartition(topics, 0); 
		    
		    Map<TopicPartition, Long> fromOffsets = new HashMap<>();	
		    fromOffsets.put(partition, (long) 0);

		    ConsumerStrategy<Long, StockInfo> consumerStrategy =
		    		 ConsumerStrategies.Assign(Arrays.asList(partition), kafkaParams,fromOffsets);

		    JavaInputDStream<ConsumerRecord<Long, StockInfo>> stream = KafkaUtils.createDirectStream(
		            jssc,
		            LocationStrategies.PreferConsistent(),
		            consumerStrategy) ;

		 
		JavaPairDStream<Long,StockInfo> result = stream.mapToPair(record -> new Tuple2<>(record.key(), record.value()));

		 String hdfsPath = hiveHDFSFolder;

		 Configuration configuration = new Configuration();
		 configuration.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
			    
		 configuration.set("fs.defaultFS", hdfsURL);
		 FileSystem fs = FileSystem.get(configuration);
		 
		 Timestamp ts = new Timestamp(System.currentTimeMillis());
		 Long t = ts.getTime();
		 
		
		 result.foreachRDD(ds -> { 

				if (!ds.isEmpty()) { 
				
					Long tt = t+ds.first()._1;
					String fileName = tt.toString();
					
					String dir = hdfsPath+fileName;
					
					ds.saveAsHadoopFile(dir, Long.class, StockInfo.class, TextOutputFormat.class);
		
				 	fs.rename(new Path(dir+"/part-00000"), new Path (dir+".txt"));
				 		
				 	fs.delete(new Path (dir), false);

				}
			 });

		// Start the computation
		 jssc.start();
		 jssc.awaitTermination(); 

	
	}
}