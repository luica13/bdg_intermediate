import java.util.concurrent.*;

public class Main4 {

    public static void main(String[] args) {
        System.out.println("Main " + Thread.currentThread().getName());

        Counter2 counter = new Counter2();

        Thread runThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread runThread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        runThread.start();
        runThread2.start();

        
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter);
    }
}

class Counter2 {
    private Integer counter = 0;

    public synchronized void increment() {
        counter++;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "counter=" + counter +
                '}';
    }
}

