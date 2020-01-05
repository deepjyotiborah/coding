package com.dee.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerDemoWithCallback {
    public static void main(String[] args) {

        String bootstrapServer = "127.0.0.1:9092";
        //Create producer properties
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //Create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        //Create producer record
        ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("first_Topic", "Hello World!! Started producing messages.");

        // Send Data
        producer.send(producerRecord, new ProducerCallback());

        //Flush data
        producer.flush();

        //Flush & close producer
        producer.close();
    }
}
