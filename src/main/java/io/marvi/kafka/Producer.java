package io.marvi.kafka;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

public class Producer {

    final private static String PROPERTIES_FILE_PATH  = "conf/producer.properties";

    public void produce(String topic, String bootstrap) {

        Properties config = readProducerConfig();

        new KafkaProducer<K, V>(config);
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
