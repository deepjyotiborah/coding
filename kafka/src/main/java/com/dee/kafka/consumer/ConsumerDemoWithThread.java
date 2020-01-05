package com.dee.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class ConsumerDemoWithThread {
    private static Logger logger = LoggerFactory.getLogger(ConsumerDemoWithThread.class.getName());

    public static void main(String[] args) {
        new ConsumerDemoWithThread().run();
    }

    private void run() {
        String bootstrapServer = "127.0.0.1:9092";
        String topic = "first_Topic";
        String groupId = "first_consumer-group";

        CountDownLatch latch = new CountDownLatch(1);
        ConsumerRunnable consumerRunnable = new ConsumerRunnable(topic, bootstrapServer, groupId, latch);
        Thread consumerThread = new Thread(consumerRunnable);
        consumerThread.start();

        Runtime.getRuntime().addShutdownHook(new Thread( () -> {
            logger.info("Caught shutdown hook");
            consumerRunnable.shutdown();
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("Application has exited.");
        }));

        try {
            latch.await();
        } catch (InterruptedException e) {
            logger.error("Application got interrupted.", e);
        } finally {
            logger.info("Application is closing");
        }
    }
}

class ConsumerRunnable implements Runnable{
    private final String topic;
    private final String bootstrapServer;
    private final String groupId;
    private final CountDownLatch latch;
    private KafkaConsumer<String, String> consumer;

    private Logger logger = LoggerFactory.getLogger(ConsumerRunnable.class.getName());
    public ConsumerRunnable(String topic, String bootstrapServer, String groupId, CountDownLatch latch) {
        this.topic = topic;
        this.bootstrapServer = bootstrapServer;
        this.groupId = groupId;
        this.latch = latch;

        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        this.consumer = new KafkaConsumer<String, String>(properties);

        //Subscribe consumer to topic(s)
        this.consumer.subscribe(Arrays.asList(topic));
    }

    @Override
    public void run() {
        //Poll for new messages
        try {
            while (true) {
                ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record : consumerRecords) {
                    logger.info("Key: " + record.key() + ", Value : " + record.value());
                }
            }
        } catch (WakeupException ex) {
            logger.info("Received shutdown signal");
        }finally {
            consumer.close();

            //Tells the main code we're done with the consumer
            latch.countDown();
        }
    }

    public void shutdown(){
        consumer.wakeup();
    }
}
