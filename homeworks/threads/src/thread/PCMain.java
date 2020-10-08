package thread;

import thread.buffer.IntegerBuffer;
import thread.consumer.Consumer;
import thread.consumer.ConsumerImpl;
import thread.producer.Producer;
import thread.producer.ProducerImpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PCMain {
    private static final Logger LOGGER = Logger.getLogger(PCMain.class.getName());
    private final Producer producer;
    private final Consumer consumer;

    PCMain() {
        IntegerBuffer buffer = new IntegerBuffer();
        producer = new ProducerImpl(buffer);
        consumer = new ConsumerImpl(buffer);
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        PCMain pcMain = new PCMain();
        executorService.submit(() -> {
            try {
                pcMain.producer.produce();
            } catch (InterruptedException e) {
                LOGGER.log(Level.SEVERE, e.getMessage());
            }
        });

        executorService.submit(() -> {
            try {
                pcMain.consumer.consume();
            } catch (InterruptedException e) {
                LOGGER.log(Level.SEVERE, e.getMessage());
            }
        });
        Thread.sleep(20000);
        executorService.shutdownNow();
    }
}
