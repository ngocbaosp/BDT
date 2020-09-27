package cs523.finalproject.kafka;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import cs523.finalproject.kafka.model.StockInfo;


public class MyValueDeserializer implements Deserializer<StockInfo>
{
    private boolean isKey;

    @Override
    public void configure(Map<String, ?> configs, boolean isKey)
    {
        this.isKey = isKey;
    }

    @Override
    public StockInfo deserialize(String s, byte[] value)
    {
        if (value == null) {
            return null;
        }

        try {

            
        	ObjectMapper mapper = new ObjectMapper();


        	StockInfo message = new StockInfo();
            
        	try {
        		message = mapper.readValue(value, StockInfo.class);
            } catch (Exception e) {
              e.printStackTrace();
            }

            return message;

        } catch (RuntimeException e) {
            throw new SerializationException("Error deserializing value", e);
        }
    }

    @Override
    public void close()
    {

    }
}