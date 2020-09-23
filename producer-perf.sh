#!/bin/bash
/home/marvi/Documents/kafka_2.12-2.6.0/bin/kafka-producer-perf-test.sh --topic benchmark-2 \
--num-records 150000 \
--record-size 600 \
--throughput -1 \
--producer-props \
acks=1 \
bootstrap.servers=188.166.86.73:9092 \
compression.type=snappy \
batch.size=256


#~/Documents/kafka_2.12-2.6.0/bin/kafka-run-class.sh \
#  kafka.tools.EndToEndLatency \
#  localhost:9092 \
#  benchmark-1 \
#100000 \
#1 \
#600
