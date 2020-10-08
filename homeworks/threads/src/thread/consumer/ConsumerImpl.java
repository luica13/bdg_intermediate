package thread.consumer;

import thread.buffer.IntegerBuffer;

public class ConsumerImpl implements Consumer {
    private final IntegerBuffer buffer;

    public ConsumerImpl(IntegerBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void consume() throws InterruptedException {
        while (true) {
            synchronized (buffer) {
                while (buffer.isEmpty())
                    buffer.wait();

                System.out.println(String.format("Consumer received value: %s", buffer.retrieveValue()));

                buffer.notify();

                Thread.sleep(1000);
            }
        }
    }
}
