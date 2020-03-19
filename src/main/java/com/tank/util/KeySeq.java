package com.tank.util;

import com.google.common.collect.Queues;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

@Slf4j
public class KeySeq {


  public void initOnce() {
    if (!this.queue.isEmpty()) {
      return;
    }
    for (int i = 0; i < MAX_THRESHOLD; i++) {
      this.queue.add(String.valueOf(i));
    }
  }

  @SneakyThrows
  public String take() {

    try {
      lock.lock();

      if (queue.size() <= MIN_THRESHOLD) {
        producerCondition.signal();
        customerCondition.await();
      }
      log.info("consumer thread");
      return queue.poll();
    } finally {
      lock.unlock();
    }

  }

  public void startMonitorOnce() {
    if (running) {
      log.info("monitor only allowed started once");
      return;
    }
    running = true;
    new Thread(() -> {
      String producerName = Thread.currentThread().getName();
      try {
        lock.lock();
        while (running) {
          producerCondition.await();
          log.info("thread:[{}] is working", producerName);
          int differ = MAX_THRESHOLD - this.queue.size();
          IntStream.range(0, differ).boxed().forEach(i -> queue.add(String.valueOf(i)));
          customerCondition.signal();
        }

      } catch (Exception e) {
        log.error("thread :[{}] error", producerName);
      } finally {
        lock.unlock();
      }

    }, "producer-thread").start();

  }


  private Queue<String> queue = Queues.newConcurrentLinkedQueue();

  private ReentrantLock lock = new ReentrantLock();

  private Condition producerCondition = lock.newCondition();

  private Condition customerCondition = lock.newCondition();

  private final static int MIN_THRESHOLD = 50;

  private final static int MAX_THRESHOLD = 300;

  private volatile boolean running = false;

}
