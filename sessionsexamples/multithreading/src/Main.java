import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static AtomicInteger c = new AtomicInteger(0);
    public static void main(String[] args) {
        System.out.println("Main " + Thread.currentThread().getName());

        Counter counter = new Counter();
        //int counter = 0;
        Thread runThread = new Thread(()-> {
            System.out.println("Run thread " + Thread.currentThread().getName());
            for(int i=0;i<1000;i++){
                counter.counter++;
                c.incrementAndGet();
            }
        });
        Thread runThread2 = new Thread(()-> {
            System.out.println("Run thread " + Thread.currentThread().getName());
            for(int i=0;i<1000;i++){
                counter.counter++;
                c.incrementAndGet();
            }
        });

        runThread.start();
        runThread2.start();

        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.counter);
        System.out.println(c);
    }
}
class Counter {
    public Integer counter = 0;

    @Override
    public String toString() {
        return "Counter{" +
                "counter=" + counter +
                '}';
    }
}
class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("Mythread " + Thread.currentThread().getName());

    }
}
