package Homework.producer_consumer1;

import java.util.ArrayList;

public class ProducerConsumerDriver {

    public static void main(String[] args) {
        ArrayList<Integer> q = new ArrayList<Integer>();
        Producer p = new Producer(q);
        Consumer c = new Consumer(q);
        Thread procucerThread = new Thread(p);
        Thread consumerThread = new Thread(c);
        procucerThread.start();
        consumerThread.start();

    }

}
