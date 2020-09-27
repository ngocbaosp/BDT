package cs523.finalproject.kafka.service;


import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import cs523.finalproject.kafka.model.StockInfo;
import cs523.finalproject.kafka.model.StockRecord;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class StockRESTApi
{
	public StockRESTApi()
	{
		
	}
	
	public StockInfo GetStockInfoByURL(String restURL) throws JsonParseException, JsonMappingException, IOException
	{
		
		ObjectMapper mapper = new ObjectMapper();

		String jsonData = new RestTemplate().getForObject(restURL, String.class);
		
        StockInfo stock  = mapper.readValue(jsonData, StockInfo.class);
        
        return stock;
        
	}
	
	public StockRecord GetStockRecord(String restURL) throws JsonParseException, JsonMappingException, IOException
	{
		
		ObjectMapper mapper = new ObjectMapper();

		String jsonData = new RestTemplate().getForObject(restURL, String.class);
		
        StockInfo stock  = mapper.readValue(jsonData, StockInfo.class);
        
        Timestamp ts = new Timestamp(System.currentTimeMillis());
		
		long t = ts.getTime();
		
		StockRecord res = new StockRecord(t, stock);
        
        return res;
        
	}
	
}