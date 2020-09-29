package multithreading;

public class ProducerConsumerProblem {

    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.setName("producer");
        producer.start();
        Consumer consumer = new Consumer(producer);
        consumer.setName("consumer");
        consumer.start();
    }
}
