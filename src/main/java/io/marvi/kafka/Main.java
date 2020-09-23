package io.marvi.kafka;


import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

@Command(name = "kafka-test", mixinStandardHelpOptions = true, version = "kafka-test 1.0",
        description = "Simple Apache Kafka test suite with a producer and consumer")
public class Main implements Callable<Integer> {

    private static final AtomicBoolean shutdownRequested = new AtomicBoolean(false);

    @Option(names = {"-w", "--workers"}, description = "Number of producer/consumer worker threads")
    private Integer workers = 2;

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
        ExecutorService service = Executors.newFixedThreadPool(workers);
        System.out.println("Hello " + role);
        IntStream.range(0, workers)
                .forEach(i -> service.execute());
        return 1;
    }

}
