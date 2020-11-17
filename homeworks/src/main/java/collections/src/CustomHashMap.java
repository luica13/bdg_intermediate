package collections.src;

import java.util.Arrays;
import java.util.Objects;

public class CustomHashMap<K, V> {
    private Entry<K, V>[] table;
    private int capacity;
    private int entryCount;

    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        entryCount = 0;
    }

    public CustomHashMap() {
        this(16);
    }

    public void put(K key, V value) {
        if (key == null)
            return;
        if (table == null) {
            table = new Entry[capacity];
        }
        int hash = hash(key);
        Entry<K, V> newEntry = new Entry<K, V>(key, value, null);

        if (table[hash] == null) {
            table[hash] = newEntry;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) {
                if (current.key.equals(key)) {
                    if (previous == null) {
                        newEntry.next = current.next;
                        table[hash] = newEntry;
                        return;
                    } else {
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        return;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }
        entryCount++;
    }

    public V get(K key) {
        int hash = hash(key);
        if (table[hash] == null) {
            return null;
        } else {
            Entry<K, V> temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key))
                    return temp.value;
                temp = temp.next;
            }
            return null;
        }
    }

    public boolean remove(K Key) {

        int hash = hash(Key);

        if (table[hash] == null) {
            return false;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) {
                if (current.key.equals(Key)) {
                    if (previous == null) {
                        table[hash] = table[hash].next;
                        entryCount--;
                        return true;
                    } else {
                        previous.next = current.next;
                        entryCount--;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }

    }

    public void display() {

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                Entry<K, V> entry = table[i];
                while (entry != null) {
                    System.out.print("{" + entry.key + "=" + entry.value + "}" + " ");
                    entry = entry.next;
                }
            }
        }

    }

    public int size() {
        return entryCount;
    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private int hash(Object key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomHashMap<?, ?> that = (CustomHashMap<?, ?>) o;
        return capacity == that.capacity &&
                Arrays.equals(table, that.table);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(capacity);
        result = 31 * result + Arrays.hashCode(table);
        return result;
    }
}
