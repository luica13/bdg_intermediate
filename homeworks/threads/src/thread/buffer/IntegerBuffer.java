package thread.buffer;

import java.util.LinkedList;

public class IntegerBuffer {
    private final LinkedList<Integer> messageBuffer;
    private static final int BUFFER_CAPACITY = 1;

    public IntegerBuffer() {
        messageBuffer = new LinkedList<>();
    }

    public boolean isEmpty() {
        return messageBuffer.isEmpty();
    }

    public boolean isFull() {
        return messageBuffer.size() == BUFFER_CAPACITY;
    }

    public Integer retrieveValue() {
        return messageBuffer.removeFirst();
    }

    public void putValue(Integer value) {
        messageBuffer.add(value);
    }
}
