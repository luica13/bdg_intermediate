package Homework.producer_consumer1;

import java.util.ArrayList;

public class Producer implements Runnable {

    private ArrayList<Integer> q;

    public Producer(ArrayList<Integer> q) {
        this.q = q;
    }

    @Override
    public void run() {
        System.out.println("Inside run method of Producer thread.");

        while(true){
            synchronized (q) {

                if(q.size() != 0){
                    try {
                        q.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    for(int i=0;i<10;i++){
                        q.add(i);
                    }
                    System.out.println("Queue is full, sending notification to Consumer");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
// TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    q.notify();
                }

            }
        }

    }

}

