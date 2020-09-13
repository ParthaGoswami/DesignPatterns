package com.concurrency.producerconsumer;

import java.util.Queue;

public class Consumer implements Runnable {

    private Queue<Double> queue;
    private Integer size;

    public Consumer(Queue<Double> queue, Integer size) {
        this.queue = queue;
        this.size = size;
    }

    @Override
    public void run() {

        while(true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println("Queue Empty  - " + Thread.currentThread().getName() + " will WAIT...");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Double val = queue.poll();
                System.out.println("Consumed By Thread - " + Thread.currentThread().getName() + "  Val :: " + val);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.notifyAll();
            }
        }
    }
}
