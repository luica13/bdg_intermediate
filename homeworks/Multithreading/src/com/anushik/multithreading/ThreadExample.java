package com.anushik.multithreading;

public class ThreadExample {
    public static void main(String[] args) {
        ProducerConsumer producer_consumer = new ProducerConsumer();
        Thread producerThread = new Thread(() -> {
            try {
                producer_consumer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread consumerThread = new Thread(() -> {
            try {
                producer_consumer.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}