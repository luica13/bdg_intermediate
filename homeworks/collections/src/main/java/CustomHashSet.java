package main;

public class CustomHashSet<T> {
    class Node<T> {
        Object data;
        Node next;
    }

    private Node[] buckets;
    private int size;

    public CustomHashSet(int capacity) {
        this.buckets = new Node[capacity];
        this.size = 0;
    }

    private int hashFunction(int hashCode) {
        int index = hashCode;
        if (index < 0) {
            index = -index;
        }
        return index % buckets.length;
    }

    public boolean add(Object element) {
        int index = hashFunction(element.hashCode());
        Node current = buckets[index];

        while (current != null) {
            if (current.data.equals(element)) {
                return false;
            }
            current = current.next;
        }

        Node entry = new Node();
        entry.data = element;
        entry.next  = buckets[index];
        buckets[index] = entry;
        size++;

        return true;
    }

    public boolean remove(Object element) {
        int index = hashFunction(element.hashCode());
        Node current = buckets[index];
        Node previous = null;

        while (current != null) {
            if (current.data.equals(element)) {

                if (previous == null) {
                    buckets[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }

        return false;
    }

    @Override
    public String toString() {
        Node currentEntry = null;
        StringBuffer sb = new StringBuffer();

        for (int index=0; index < buckets.length; index++) {
            if (buckets[index] != null) {
                currentEntry = buckets[index];
                sb.append("[" + index + "]");
                sb.append(" " + currentEntry.data.toString());
                while (currentEntry.next != null) {
                    currentEntry = currentEntry.next;
                    sb.append(" -> " + currentEntry.data.toString());
                }
                sb.append('\n');
            }
        }

        return sb.toString();
    }
}
