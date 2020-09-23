#!/bin/bash
/home/marvi/Documents/kafka_2.12-2.6.0/bin/kafka-producer-perf-test.sh --topic benchmark-3 \
--num-records 1500000 \
--record-size 600 \
--throughput -1 \
--producer-props \
acks=1 \
bootstrap.servers=188.166.86.73:9092 \
buffer.memory=67108864 \
compression.type=snappy \
batch.size=65537 \
linger.ms=5

#~/Documents/kafka_2.12-2.6.0/bin/kafka-run-class.sh \
#  kafka.tools.EndToEndLatency \
#  localhost:9092 \
#  benchmark-1 \
#100000 \
#1 \
#600
