package com.anushik.multithreading;

import java.util.LinkedList;

public class ProducerConsumer {
    LinkedList<Integer> queue = new LinkedList<>();

    public void produce() throws InterruptedException {
        int value = 0;

        while (true) {
            synchronized (this) {
                while (queue.size() == 1) {
                    wait();
                }

                System.out.println("Producer add: " + value);
                queue.add(value++);

                notify();

                Thread.sleep(500);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (queue.size() == 0) {
                    wait();
                }

                int value = queue.removeFirst();
                System.out.println("Consumer remove: " + value);

                notify();

                Thread.sleep(500);
            }
        }
    }


}