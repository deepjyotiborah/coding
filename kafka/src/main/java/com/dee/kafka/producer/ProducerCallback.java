package com.dee.kafka.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerCallback implements Callback {
    Logger LOGGER = LoggerFactory.getLogger(ProducerCallback.class);

    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        if(e == null) {
            LOGGER.info("Successfully sent messages. \n"
                    + "Topic: " + recordMetadata.topic() + "\n"
                    + "Partition: " + recordMetadata.partition() + "\n"
                    + "Offset: " + recordMetadata.offset() + "\n"
                    + "Timestamp: " + recordMetadata.timestamp());
        } else {
            LOGGER.error("Exception while producing. " + e.getMessage());
        }
    }
}
