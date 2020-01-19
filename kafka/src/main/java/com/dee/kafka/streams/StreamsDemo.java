package com.dee.kafka.streams;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;

import java.util.Properties;

public class StreamsDemo {

    public static void main(String[] args) {

        //Create peoperties
        Properties properties = new Properties();
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "demo-kafka-streams");
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.StringSerde.class.getName());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.StringSerde.class.getName());

        //Create a topology
        StreamsBuilder streamsBuilder = new StreamsBuilder();

        //Input topic
        KStream<Object, Object> inputTopic = streamsBuilder.stream("first_Topic");
        KStream<Object, Object> filteredStream = inputTopic.filter(
                (k, message) -> isEvenId(message.toString())
        );

        filteredStream.to("streams_topic");

        //Build the topology
        KafkaStreams kafkaStreams = new KafkaStreams(streamsBuilder.build(), properties);
        kafkaStreams.start();

    }
    private static boolean isEvenId(String message) {
        int index = 0;
        try {
            index = Integer.parseInt(message.substring(message.length() - 1));
        } catch (NumberFormatException e) {
            return false;
        }
        return index % 2 == 0;
    }
}
