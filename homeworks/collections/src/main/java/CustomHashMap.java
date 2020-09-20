package main;

import java.io.Serializable;
import java.util.*;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//public class Main {
//
//
//}

public class CustomHashMap<K, V> {

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final int MAXIMUM_CAPACITY = 1073741824;
    //static final float DEFAULT_LOAD_FACTOR = 0.75F;
//    static final int TREEIFY_THRESHOLD = 8;
//    static final int UNTREEIFY_THRESHOLD = 6;
//    static final int MIN_TREEIFY_CAPACITY = 64;
     LinkedList<Node>[] table;
    int size;
    int capacity;

    static final int hash(Object key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ h >>> 16;
    }




    public CustomHashMap() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public CustomHashMap(int initCapacity) {
        size = 0;
        if (initCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + initCapacity);
        } else {
            if (initCapacity > MAXIMUM_CAPACITY) {
                capacity = 1073741824;
            }
        }
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public V put(K key,V value)
    {
        int hash = hash(key);
        int position = hash%
    }





    static class Node<K , V> {
        final int hash;
        final K key;
        V value;

        Node(int hash, K key, V value, CustomHashMap.Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public final K getKey() {
            return this.key;
        }

        public final V getValue() {
            return this.value;
        }

        public final String toString() {
            return this.key + "=" + this.value;
        }

        public final int hashCode() {
            return Objects.hashCode(this.key) ^ Objects.hashCode(this.value);
        }

        public final V setValue(V newValue) {
            V oldValue = this.value;
            this.value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this) {
                return true;
            } else {
                if (o instanceof Node) {
                    Node<?, ?> e = (Node<?, ?>) o;
                    if (Objects.equals(this.key, e.getKey()) && Objects.equals(this.value, e.getValue())) {
                        return true;
                    }
                }

                return false;
            }
        }
    }
}