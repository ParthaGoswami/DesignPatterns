package com.concurrency.producerconsumer;

import java.util.Queue;

public class Producer implements Runnable {

    private Integer size;
    private Queue<Double> queue;

    public Producer(Queue<Double> queue , Integer size) {
        this.queue = queue;
        this.size = size;
    }

    @Override
    public void run() {

           while(true) {
               synchronized (queue) {
                   while (queue.size() == size) {
                       try {
                           System.out.println("Queue Full  - " + Thread.currentThread().getName() + " will WAIT...");
                           queue.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }

                   Double val = Math.random();
                   queue.add(val);
                   System.out.println("Produced By Thread - " + Thread.currentThread().getName() + "  Val :: " + val);
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
