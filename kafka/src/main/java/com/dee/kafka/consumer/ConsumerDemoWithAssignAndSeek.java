package com.dee.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class ConsumerDemoWithAssignAndSeek {
    private static Logger logger = LoggerFactory.getLogger(ConsumerDemoWithAssignAndSeek.class.getName());

    public static void main(String[] args) {
        String bootstrapServer = "127.0.0.1:9092";
        String topic = "first_Topic";
        String groupId = "first_consumer-group";

        //Create consumer
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

        //Subscribe consumer to topic(s)
        TopicPartition topicPartition = new TopicPartition(topic, 0);

        //assign and seek are mostly used to replay data or fetch specific messages.
        consumer.assign(Arrays.asList(topicPartition));
        consumer.seek(topicPartition, 5L);

        int maxNumberOfMessages = 5, messagesReadSoFar = 0;
        boolean keepOnReading = true;

        //Poll for new messages
        while (keepOnReading) {
            ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record : consumerRecords) {
                messagesReadSoFar += 1;
                logger.info("Key: " + record.key() + ", Value : " + record.value() + ", Partition: " + record.partition());
                if (messagesReadSoFar >= maxNumberOfMessages)
                    keepOnReading = false;
            }
        }
    }
}
