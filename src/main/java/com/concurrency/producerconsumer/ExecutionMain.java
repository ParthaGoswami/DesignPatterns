package com.concurrency.producerconsumer;

import java.util.ArrayDeque;
import java.util.Queue;

public class ExecutionMain {

    public static void main(String[] args) {

        Integer size = 10;
        Queue<Double> queue = new ArrayDeque<>();

        Thread consumer1 = new Thread(new Consumer(queue,size));
        consumer1.setName("Consumer1");
        Thread consumer2 = new Thread(new Consumer(queue,size));
        consumer2.setName("Consumer2");
        Thread consumer3 = new Thread(new Consumer(queue,size));
        consumer3.setName("Consumer3");


        Thread producer1 = new Thread(new Producer(queue,size));
        producer1.setName("Producer1");
        Thread producer2 = new Thread(new Producer(queue,size));
        producer2.setName("Producer2");
        Thread producer3 = new Thread(new Producer(queue,size));
        producer3.setName("Producer3");


        System.out.println("Starting All Threads......");

        producer1.start();
        producer2.start();
        producer3.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();


    }
}
