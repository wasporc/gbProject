package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class CountLock {
    private static final int NUM_INCREMENTS = 100;

    private static Lock lock = new ReentrantLock();

    private static int count = 0;

    private static void increment() {
        lock.lock();
        try {
            count++;
            System.out.println(count);
            System.out.println(Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        testLock();
    }

    private static void testLock() {
        count = 0;
        ExecutorService executor = Executors.newFixedThreadPool(2);
        IntStream.range(0, NUM_INCREMENTS)
                .forEach(i -> executor.submit(CountLock::increment));
        executor.shutdown();
    }
}
