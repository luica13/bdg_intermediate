import java.util.*;

public class CustomHashSet{
    private static class Entry {
        Object key;
        Entry next;
    }
    private Entry[] buckets;

    private int size;

    public CustomHashSet(){
        buckets=new Entry[16];
        size=0;
    }

    public CustomHashSet(int capacity) {

        buckets = new Entry[capacity];
        size = 0;
    }
    private int hashFunction(int hashCode) {

        int index = hashCode;
        if (index < 0) { index = -index; }
        return index % buckets.length;
    }

    public boolean add(Object element) {

        int index = hashFunction(element.hashCode());
        Entry current = buckets[index];

        while (current != null) {
            if (current.key.equals(element)) { return false; }
            current = current.next;
        }
        Entry entry = new Entry();
        entry.key = element;
        entry.next  = buckets[index];
        buckets[index] = entry;
        size++;
        return true;
    }

    public boolean remove(Object element) {

        int index = hashFunction(element.hashCode());
        Entry current = buckets[index];
        Entry previous = null;

        while (current != null) {

            if (current.key.equals(element)) {

                if (previous == null) {
                    buckets[index] = current.next;
                }
                else {
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

    public boolean contains(Object element) {

        int index = hashFunction(element.hashCode());
        Entry current = buckets[index];

        while (current != null) {
            if (current.key.equals(element)) { return true; }
            current = current.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public static void main(String[] args) {
        CustomHashSet hashset=new CustomHashSet();
        hashset.add("Lion");
        hashset.add("Dog");
        hashset.add("Cat");
        System.out.println(hashset.size());
        System.out.println(hashset.isEmpty());
        System.out.println(hashset.contains("Bear"));
        hashset.remove("Lion");
        System.out.println(hashset.size());
        System.out.println(hashset.contains("Lion"));

    }
}