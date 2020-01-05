package com.dee.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class ProducerDemoWithKeys {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        String bootstrapServer = "127.0.0.1:9092";
        String topic = "first_Topic";
        String message = "Hello World ";
        String key = "id_";

        //Create producer properties
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //Create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        for (int i = 0; i < 5 ; i++ ) {
            //Create producer record
            ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(topic, key+i,message + i);
            System.out.println("Key - " + (key+i));
            // Send Data
            producer.send(producerRecord, new ProducerCallback()).get();
        }

        //Flush data
        producer.flush();

        //Flush & close producer
        producer.close();
    }
}
