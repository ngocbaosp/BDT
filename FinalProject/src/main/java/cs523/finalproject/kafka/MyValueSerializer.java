package cs523.finalproject.kafka;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import cs523.finalproject.kafka.model.StockInfo;


public class MyValueSerializer implements Serializer<StockInfo>
{
    private boolean isKey;

    @Override
    public void configure(Map<String, ?> configs, boolean isKey)
    {
        this.isKey = isKey;
    }

    @Override
    public byte[] serialize(String topic, StockInfo message)
    {
        if (message == null) {
            return null;
        }

        try {


        	byte[] retVal = null;
            ObjectMapper objectMapper = new ObjectMapper();
            try {
              retVal = objectMapper.writeValueAsString(message).getBytes();
            } catch (Exception e) {
              e.printStackTrace();
            }
            return retVal;

            //return bytes;

        } catch (RuntimeException e) {
            throw new SerializationException("Error serializing value", e);
        }
    }

    @Override
    public void close()
    {

    }
}