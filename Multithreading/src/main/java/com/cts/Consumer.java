package com.cts;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer item = queue.poll(1, TimeUnit.SECONDS); // Poll item with a timeout
                if (item != null) {
                    System.out.println("Consumed: " + item);
                } else {
                    // Optionally handle the case where no item is available
                    System.out.println("No items to consume, waiting...");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Consumer interrupted.");
        }
    }
}