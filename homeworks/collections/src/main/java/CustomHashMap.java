package main;

public class CustomHashMap<K, V> {
    private Entry<K, V>[] table;
    private int capacity;

    public CustomHashMap(int capacity) {
        this.capacity = capacity;
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
                        return true;
                    } else {
                        previous.next = current.next;
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
}

class CustomHashMapApp {
    public static void main(String[] args) {
        CustomHashMap<Integer, String> customHashMap = new CustomHashMap<>();
        customHashMap.put(1, "one");
        customHashMap.put(2, "two");
        customHashMap.put(3, "three");
        customHashMap.put(4, "four");
        customHashMap.put(5, "five");
        customHashMap.display();
        System.out.println();
        System.out.println();
        customHashMap.put(5, "seven");
        customHashMap.display();
        System.out.println();
        System.out.println();
        System.out.println(customHashMap.get(4));
        System.out.println();
        System.out.println();
        customHashMap.remove(4);
        customHashMap.display();
    }

}
