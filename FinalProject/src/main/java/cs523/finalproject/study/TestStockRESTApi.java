package cs523.finalproject.study;

import java.io.IOException;
import java.sql.Timestamp;

import org.springframework.web.client.RestTemplate;

import cs523.finalproject.kafka.model.StockInfo;
import cs523.finalproject.kafka.model.StockRecord;
import cs523.finalproject.kafka.service.StockRESTApi;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class TestStockRESTApi
{
	public static String restURL ="https://sandbox.iexapis.com/stable/stock/AAPL/quote?token=Tsk_2ec682f2ca234a04bb108023943ea5e8";

	public static void main(String[] args) throws Exception{

		StockRESTApi api = new StockRESTApi();
		
		String s = api.GetStockInfoByURL(restURL).toString();

		System.out.println(s);	 	      
		System.out.println("Message sent successfully dddddd");
		
		
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		
		long t = ts.getTime();
		
		System.out.println(t);	 	      
		
		
		StockRecord sr = api.GetStockRecord(restURL);
		
		System.out.println(sr);	 	      
		
		
		
		
		
	 	      
	}	
	
}