#!/bin/bash

/home/marvi/Documents/kafka/bin/kafka-consumer-perf-test.sh \
  --broker-list 188.166.86.73:9092 \
  --messages 150000 \
  --topic benchmark-2 \
  --threads 333 \
  --print-metrics \
  --show-detailed-stats
