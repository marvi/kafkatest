#!/bin/bash

/home/marvi/Documents/kafka/bin/kafka-consumer-perf-test.sh \
  --broker-list 188.166.86.73:9092 \
  --messages 1500000 \
  --topic benchmark-3 \
  --threads 3 \
  --print-metrics \
  --show-detailed-stats
