import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockExample {
    int count = 0;
    //    Lock lock = new ReentrantLock();
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        LockExample lockExample = new LockExample();
        for (int i = 0; i < 15; i++) {
            executorService.execute(lockExample::increment);
            executorService.execute(lockExample::increment);
            executorService.execute(lockExample::increment);
            executorService.execute(lockExample::increment);
            executorService.execute(lockExample::increment);
            executorService.execute(lockExample::increment);
            executorService.execute(lockExample::increment);
            executorService.execute(lockExample::increment);
            executorService.execute(lockExample::increment);
            executorService.execute(lockExample::increment);
            executorService.execute(lockExample::increment);
            executorService.execute(lockExample::increment);
            executorService.execute(lockExample::increment);
            executorService.execute(lockExample::increment);
            executorService.execute(lockExample::increment);
            executorService.execute(lockExample::increment);
            executorService.execute(lockExample::increment);
            executorService.execute(lockExample::increment);
            executorService.execute(lockExample::increment);
        }
        executorService.shutdown();
    }

    public void increment() {
//        lock.lock();
        lock.writeLock();
        try {
            System.out.println(Thread.currentThread().getName());
            count++;
            System.out.println("The count is: " + count);
        } finally {
//            lock.unlock();
            if (lock.isWriteLocked())
                lock.writeLock().unlock();
        }
    }
}