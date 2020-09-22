package io.marvi.kafka;


import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(name = "kafka-test", mixinStandardHelpOptions = true, version = "kafka-test 1.0",
        description = "Simple Apache Kafka test suite with a producer and consumer")
public class Main implements Callable<Integer> {

    @Option(names = {"-r", "--role"}, required = true, description = "producer or consumer")
    private String role = "producer";

    @Option(names = {"-t", "--topic"}, description = "Kafka topic to produce to or consume from")
    private String topic = "test";

    @Option(names = {"-e", "--eps"}, description = "Event per second to produce")
    private Integer eps = 1000;

    public static void main(String[] argv) {
        int exitCode = new CommandLine(new Main()).execute(argv);
        System.exit(exitCode);
    }

    public Integer call() {
        System.out.println("Hello " + role);
        return 1;
    }

}
