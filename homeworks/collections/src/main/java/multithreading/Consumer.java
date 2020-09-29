package multithreading;

public class Consumer extends Thread {
    private Producer producer;

    public Consumer (Producer producer) {
        this.producer = producer ;
    }

    @Override
    public void run() {
        int data = 0;
        try {
            data = producer.consumed();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("consumed " + Thread.currentThread().getName() +"  data " +data);

    }
}
