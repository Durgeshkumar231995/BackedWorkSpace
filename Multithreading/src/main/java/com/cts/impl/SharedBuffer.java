package com.cts.impl;

class SharedBuffer {
    private final int[] buffer;
    private int count, in, out;
    private final int capacity;

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
        count = 0;
        in = 0;
        out = 0;
    }

    public synchronized void put(int item) throws InterruptedException {
        while (count == capacity) {
            wait(); // Wait if the buffer is full
        }
        buffer[in] = item;
        in = (in + 1) % capacity;
        count++;
        notifyAll(); // Notify any waiting consumers
    }

    public synchronized int take() throws InterruptedException {
        while (count == 0) {
            wait(); // Wait if the buffer is empty
        }
        int item = buffer[out];
        out = (out + 1) % capacity;
        count--;
        notifyAll(); // Notify any waiting producers
        return item;
    }
}
