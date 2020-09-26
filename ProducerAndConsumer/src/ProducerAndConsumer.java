import java.util.ArrayDeque;
import java.util.Queue;

public class ProducerAndConsumer {
    public static void main(String[] args) {
        PC pc = new PC();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}

class PC {
    Queue<Integer> queue = new ArrayDeque<>();
    private int capacity = 1;
    int element;
    public synchronized void produce(int element) throws InterruptedException {
        while (true) {
            if (queue.size() == capacity) {
                    wait();
                }
                this.element=element;
                System.out.println("Produced Element is: " + element);
                queue.add(element++);
                notify();
                Thread.sleep(1000);
            }
        }

    public synchronized void consume() throws InterruptedException {
        while (true) {
            if (queue.size() == 0) {
                    wait();
                }
                element=queue.poll();
                System.out.println("Consumed Element is: " + element);
                notify();
                Thread.sleep(1000);
            }
        }
    }
