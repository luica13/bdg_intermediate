import java.util.LinkedList;

public class Threadexample {
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer producer_consumer = new ProducerConsumer();
        Thread thread1 = new Thread(() -> {
            try {
                producer_consumer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try{
                producer_consumer.consume();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();



    }

    public static class ProducerConsumer {
        LinkedList<Integer> queue = new LinkedList<>();
        final int capacity = 5;

        public void produce() throws InterruptedException {
            int value = 0;

            while(true) {
                synchronized (this) {
                    while (queue.size() == capacity) {
                        wait();
                    }

                    System.out.println("Producer add: " + value);
                    queue.add(value++);

                    notify();

                    Thread.sleep(500);
                }
            }
        }

        public void consume() throws InterruptedException {
            while(true) {
                synchronized (this) {
                    while (queue.size() == 0) {
                        wait();
                    }

                    int value = queue.removeFirst();
                    System.out.println("Consumer remove: " + value);

                    notify();

                    Thread.sleep(500);
                }
            }
        }
    }
}