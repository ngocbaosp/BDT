package cs523.finalproject.kafka;

//import util.properties packages
import java.util.Properties;
import java.util.Timer; 
import java.util.TimerTask; 





//import simple producer packages
import org.apache.kafka.clients.producer.Producer;

//import KafkaProducer packages
import org.apache.kafka.clients.producer.KafkaProducer;

//import ProducerRecord packages
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import cs523.finalproject.kafka.model.StockInfo;
import cs523.finalproject.kafka.model.StockRecord;
import cs523.finalproject.kafka.service.StockRESTApi;


public class StockProducer {

	public static void main(String[] args) throws Exception{

	      String topicName = args[0].toString();
	      int duration = 5000;//5 seconds
	      String ticker = "AAPL";//By default Apple
	      //ticker = "GOOGL"; Google
	      String token ="Tsk_2ec682f2ca234a04bb108023943ea5e8";
	      String apiURL = "https://sandbox.iexapis.com/stable/stock/";
	      
	      if (args.length>=2)
	    	  ticker = args[1].toString();      
	 	  
	      if (args.length >=3)
	      {
	    	  duration = Integer.parseInt(args[2].toString());	     
	    	  duration = duration*1000;
	      }

	      if (args.length>=4)
	    	  token = args[3].toString();      	 	  
	    
	      if (args.length>=5)
	    	  apiURL = args[4].toString();      	 	  
	    
	      
	      String restURL =apiURL+ticker+"/quote?token="+token;
		  
	      
	      // create instance for properties to access producer configs   
	      Properties props = new Properties();
	      
	      //Assign localhost id
	      props.put("bootstrap.servers", "localhost:9092");
	      
	      //Set acknowledgements for producer requests.      
	      props.put("acks", "all");
	      
	      //If the request fails, the producer can automatically retry,
	      props.put("retries", 0);
	      
	      //Specify buffer size in config
	      props.put("batch.size", 16384);
	      
	      //Reduce the no of requests less than 0   
	      props.put("linger.ms", 1);
	      
	      //The buffer.memory controls the total amount of memory available to the producer for buffering.   
	      props.put("buffer.memory", 33554432);

	      //final IntegerSerializer keySerializer = new IntegerSerializer();
	      final LongSerializer keySerializer = new LongSerializer();
	      final MyValueSerializer myValueSerializer = new MyValueSerializer();
	      final KafkaProducer<Long, StockInfo> producer = new KafkaProducer<>(props, keySerializer, myValueSerializer);

	      
	      StockRESTApi api = new StockRESTApi();
		  StockRecord sr = api.GetStockRecord(restURL);
			
		  System.out.println(sr);	 	      

	      
	      ProducerRecord producerRecord = new ProducerRecord<>(topicName, sr.getKey(), sr.getValue());
	      producer.send(producerRecord);
	      
	 	      
	 	  System.out.println("Message sent successfully");
	 	              
	 	  
	 	 //Call RestAPI to get StockInfo 
	 	 Timer timer = new Timer(); 
	     TimerTask task = new SendStockRecordToKafkaTopic(producer,topicName,restURL);	     
	          
	     timer.schedule(task, 2000, duration); 
	 	 
	     //producer.close(); 	  
	 	 

	   }
	
}
