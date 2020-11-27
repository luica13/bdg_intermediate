package Homework.producer_consumer1;

import java.util.ArrayList;

public class Consumer implements Runnable {

    private ArrayList<Integer> q;

    public Consumer(ArrayList<Integer> q) {
        this.q = q;
    }

    @Override
    public void run() {
        System.out.println("Inside run method of Consumer thread.");
        while(true){
            synchronized (q) {
                if(q.size() != 0){
                    for(int i=0; i<10; i++){
                        q.remove(0);
                    }
                    System.out.println("Queue is empty, sending notification to Procucer");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                    q.notify();
                }
                else{
                    try {
                        q.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }


    }

}

