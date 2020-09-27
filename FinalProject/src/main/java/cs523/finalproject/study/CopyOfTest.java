package cs523.finalproject.study;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

public class CopyOfTest {

   public static void main(String[] args) {

       Properties consumerConfig = new Properties();
       consumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "quickstart.cloudera:9092");
       consumerConfig.put(ConsumerConfig.GROUP_ID_CONFIG, "tt");
       consumerConfig.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
       consumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
       consumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
       
       
       //consumerConfig.put("auto.offset.reset", "earliest");
       
	   
     //consumerConfig.put("zookeeper.connect", "quickstart.cloudera:2181");
       
       
       KafkaConsumer<byte[], byte[]> consumer = new KafkaConsumer<>(consumerConfig);
       TestConsumerRebalanceListener rebalanceListener = new TestConsumerRebalanceListener();
       consumer.subscribe(Collections.singletonList("tt"), rebalanceListener);

       int i=0;
       
       while (true) {
    	   
    	   System.out.print("1");
           
    	   
           ConsumerRecords<byte[], byte[]> records = consumer.poll(Duration.ofMillis(100));
           
           System.out.print("2");
           
           
           if (i==100) break;
           i++;
           
           System.out.print(records.count());
           
           for (ConsumerRecord<byte[], byte[]> record : records) {
               System.out.printf("Received Message topic =%s, partition =%s, offset = %d, key = %s, value = %s\n", record.topic(), record.partition(), record.offset(), record.key(), record.value());
           }

           consumer.commitSync();
       }

   }

   private static class  TestConsumerRebalanceListener implements ConsumerRebalanceListener {
       @Override
       public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
           System.out.println("Called onPartitionsRevoked with partitions:" + partitions);
       }

       @Override
       public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
           System.out.println("Called onPartitionsAssigned with partitions:" + partitions);
       }
   }

}