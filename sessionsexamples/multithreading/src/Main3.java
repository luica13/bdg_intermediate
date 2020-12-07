import java.util.concurrent.*;

public class Main3 {
    public static void main(String[] args) {
        System.out.println("Main " + Thread.currentThread().getName());

        MyCallable callable = new MyCallable();

       ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            Future<String> result = executor.submit(callable);

            try {
                System.out.println(result.get());
            } catch (InterruptedException e) {
                System.out.println("!!! InterruptedException" );
            } catch (ExecutionException e) {
                System.out.println("!!! ExecutionException" );
            }
        }
        executor.shutdown();
    }
}


class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("My runnable thread " + Thread.currentThread().getName());

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new InterruptedException();
    }
}
