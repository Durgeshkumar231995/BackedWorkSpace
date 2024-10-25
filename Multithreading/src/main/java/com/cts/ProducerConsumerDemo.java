package com.cts;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ProducerConsumerDemo {

    // Shared queue with a capacity of 5
    private static final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);

    public static void main(String[] args) {
        // Create and start Producer and Consumer threads
        Thread producerThread = new Thread(new Producer(queue));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();
    }
}