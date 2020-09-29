package multithreading;

import java.util.ArrayDeque;
import java.util.Queue;

class Producer extends Thread {
    private int i = 0;
    private static final int MAX_SIZE = 3;
    private final Queue<Integer> list = new ArrayDeque<>();

    @Override
    public void run(){
        try{
            while (true)
                addItem();
        }
        catch (Exception e){}
    }

    private synchronized void addItem() throws InterruptedException {
        while (list.size() == MAX_SIZE)
            wait();
        i++;
        list.add(i);
        System.out.println("Producer produced " + i);
        notify();
    }
    public synchronized int consumed () throws InterruptedException {
        notify();
        while (list.isEmpty())
            wait();
        return list.poll();
    }
}
