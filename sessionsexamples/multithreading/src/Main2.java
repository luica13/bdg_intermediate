import java.util.concurrent.*;

public class Main2 {

    public static void main(String[] args) {
        System.out.println("Main " + Thread.currentThread().getName());

        Counter1 counter = new Counter1();
        //int counter = 0;
        MyhRunnable rc = new MyhRunnable();
//        Thread t = new Thread(rc);
//        t.start();

        ExecutorService  ex = new ThreadPoolExecutor(1,1,0L, TimeUnit.DAYS, new LinkedBlockingDeque<>());
        ex.execute(rc);


        ExecutorService  ex2 = Executors.newFixedThreadPool(2);
        ExecutorService  ex1 = Executors.newSingleThreadExecutor();
        ex1.execute(
                rc
        );
        ex1.execute(
                rc
        );
        ex1.execute(
                rc
        );

        ex1.execute(
                rc
        );

        ex1.execute(
                rc
        );

        ex.shutdown();
        ex1.shutdown();
//
//        Thread runThread = new Thread(()-> {
//            for(int i=0;i<1000;i++){
//                System.out.println("Run thread " + Thread.currentThread().getName());
//                counter.increment();
//            }
//        });
//        Thread runThread2 = new Thread(()-> {
//
//            for(int i=0;i<1000;i++){
//                System.out.println("Run thread " + Thread.currentThread().getName());
//                counter.increment();
//            }
//        });
//
//        runThread.start();
//        runThread2.start();

        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter);
    }
}
class Counter1 {
    private  volatile Integer counter = 0;

    public  void increment(){
        System.out.println(counter);
        counter++;
        System.out.println(counter);
    }
    @Override
    public String toString() {
        return "Counter{" +
                "counter=" + counter +
                '}';
    }
}


class MyhRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("My runnable thread " + Thread.currentThread().getName());

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}