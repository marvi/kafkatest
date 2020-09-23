package io.marvi.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Producer implements Runnable {

    private Logger logger = LoggerFactory.getLogger(Producer.class);

    final private static String PROPERTIES_FILE_PATH  = "conf/producer.properties";

    @Override
    public void run() {

        Properties config = readProducerConfig();
        KafkaProducer<String, String> producer = new KafkaProducer<>(config);
        for (int i = 0; i < 10; i++) {

            ProducerRecord<String, String> record = new ProducerRecord<>(
                    "first_topic", "Hello World " + Integer.toString(i));

            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    if (exception == null) {
                        logger.info("Received new metadata: \n" + "Topic: " + metadata.topic()
                                + "\n" + "Partition: " + metadata.partition() + "\n" + "Offset: "
                                + metadata.offset() + "\n" + "Timestamp: " + metadata.timestamp());

                    } else {
                        logger.error("Error while producing", exception);
                    }
                }
            });
        }

        // flush data
        producer.flush();

        // flush and close producer
        producer.close();

    }

    private Properties readProducerConfig() {
        Properties properties = new Properties();
        try(InputStream inputStream = new FileInputStream(PROPERTIES_FILE_PATH)){
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
