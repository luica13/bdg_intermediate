package com.company;
import java.lang.Thread;

class Producer extends Thread {

    StringBuffer buffer;

    boolean obj = false;
    Thread t1;
    Producer(){
        buffer = new StringBuffer(5);

        t1 = new Thread(this);
        t1.start();
    }

    public void run(){
        for (int i = 0; i < 5; i++) {
            try {
                buffer.append(i);
                System.out.println("Produced " + i);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Buffer -> FUll");

        Consumer c = new Consumer(this);

        t1 = new Thread(c);
        t1.start();
    }
}

class Consumer extends Thread {
    Producer p;

    Consumer(Producer temp)
    {
        p = temp;
    }

    public void run()
    {
        try {
            for (int i = 0; i < 4; i++) {
                System.out.print(p.buffer.charAt(i) + " ");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\nBuffer -> Empty");
    }
}
