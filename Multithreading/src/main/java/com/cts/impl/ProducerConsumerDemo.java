package com.cts.impl;

public class ProducerConsumerDemo {

    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(5); // Shared buffer with capacity of 5

        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();
    }
}