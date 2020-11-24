package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws InterruptedException {

            final PC pc = new PC();

            // Create producer thread
            Thread t1 = new Thread(new Producer(pc));

            // Create consumer thread 1
            Thread t2 = new Thread(new Consumer(pc, "consumer_1"));
            // Create consumer thread 2
            Thread t3 = new Thread(new Consumer(pc, "consumer_2"));

            // Start threads
            t1.start();
            t2.start();
            t3.start();

            t1.join();
            t2.join();
            t3.join();
        }

        public static class PC {

            LinkedList<Integer> list = new LinkedList<>();
            int capacity = 5;

            // Function called by producer thread
            public void produce() throws InterruptedException
            {
                int value = 0;
                while (true) {
                    synchronized (this)
                    {
                        while (list.size() == capacity) {
                            wait();
                        }
                        System.out.println("Producer produced-" + value);

                        list.add(value++);
                        notify();
                        Thread.sleep(1000);
                    }
                }
            }

            // Function called by consumer thread
            public void consume(String name) throws InterruptedException
            {
                while (true) {
                    synchronized (this)
                    {
                        while (list.size() == 0) {
                            wait();
                        }
                        int val = list.removeFirst();
                        System.out.println(name + " Consumer consumed-" + val);
                        notify();
                        Thread.sleep(1000);
                    }
                }
            }
        }
    }

