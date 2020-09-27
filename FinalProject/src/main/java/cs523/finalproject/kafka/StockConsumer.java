package cs523.finalproject.kafka;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Arrays;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.LongDeserializer;

import cs523.finalproject.kafka.model.StockInfo;


public class StockConsumer {

	public static void main(String[] args) throws Exception {
		
		  	
	      if(args.length == 0){
	         System.out.println("Enter topic name");
	         return;
	      }

		//String topicName = "stockKafkaTopic";
		  String topicName = args[0].toString();
		  
		  
	      Properties props = new Properties();
	      
	      props.put("bootstrap.servers", "quickstart.cloudera:9092");
	      
	      props.put("group.id", "console-consumer-34473");
	      props.put("enable.auto.commit", "true");
	      props.put("auto.commit.interval.ms", "1000");
	      props.put("session.timeout.ms", "30000");
	      //props.put("auto.offset.reset", "earliest");
	      //props.put("auto.offset.reset", "latest");


	      
	      final LongDeserializer keyDeserializer = new LongDeserializer();
	      final MyValueDeserializer myValueDeserializer = new MyValueDeserializer();
	      final KafkaConsumer<Long, StockInfo> consumer = new KafkaConsumer<>(props, keyDeserializer, myValueDeserializer);

	      
	      TopicPartition partition = new TopicPartition(topicName, 0); 
	      
	      consumer.assign(Arrays.asList(partition)); 
	      
	      //consumer.seekToBeginning(Arrays.asList(partition)); 
		  
	      consumer.seekToEnd(Arrays.asList(partition));
	      
	      int i=0;
	      
	      while (true) {

	    	  ConsumerRecords<Long, StockInfo> records = consumer.poll(Duration.ofMillis(1000));

	    	  //System.out.println(records.partitions()); 
	         
	         if (records.count() >0)
	         {
	        	 System.out.print(i);
	        	 System.out.println(records.count()); 
	        	 i=0;
	         }
	         
	         for (ConsumerRecord<Long, StockInfo> record : records) {

		          Long kafkaKey = record.key();
		          StockInfo kafkaValue = record.value();
		          
		          System.out.printf("offset = %d, key = %s, value = %s\n", 
		  	            record.offset(), record.key().toString(), record.value().toString());
		      }
		      consumer.commitAsync();


	         i++;
	         if (i==200) break;

	      }
	      
	      
	      consumer.close();
	      
	   }
	
}
