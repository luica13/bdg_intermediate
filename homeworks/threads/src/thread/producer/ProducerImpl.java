package thread.producer;

import thread.buffer.IntegerBuffer;

public class ProducerImpl implements Producer {
    private final IntegerBuffer buffer;


    public ProducerImpl(IntegerBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void produce() throws InterruptedException {
        while (true) {
            synchronized (buffer) {
                while (buffer.isFull())
                    buffer.wait();
                int value = (int) (Math.random() * Integer.MAX_VALUE);
                System.out.println(String.format("Producer send value: %s", value));
                buffer.putValue(value);

                buffer.notify();

                Thread.sleep(1000);
            }
        }
    }
}
