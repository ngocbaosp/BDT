package cs523.finalproject.kafka;

import java.io.IOException;
import java.util.TimerTask;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import cs523.finalproject.kafka.model.StockInfo;
import cs523.finalproject.kafka.model.StockRecord;
import cs523.finalproject.kafka.service.StockRESTApi;


class SendStockRecordToKafkaTopic extends TimerTask 
{ 
    public static int i = 0; 
    
    private KafkaProducer<Long, StockInfo> producer;
    private String topicName;
    private String restURL;
    
    public SendStockRecordToKafkaTopic(KafkaProducer<Long, StockInfo> pro,String topic,String rest)
    {
    	this.producer=pro;
    	this.topicName = topic;
    	this.restURL = rest;
    }
    
    public void Send() throws JsonParseException, JsonMappingException, IOException
    {
    	 StockRESTApi api = new StockRESTApi();
		 StockRecord sr = api.GetStockRecord(restURL);
			
		 System.out.println(sr);	 	      

	      
	     ProducerRecord producerRecord = new ProducerRecord<>(topicName, sr.getKey(), sr.getValue());
	     producer.send(producerRecord);

    }
    
    public void run() 
    { 
        System.out.println("Timer ran " + ++i);
        try {
			Send();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
} 