package CustomArrayList;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator {
    private int index = 0;
    private E[] values;

    //constructor
    ArrayIterator(E[] values){
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public E next() {
        return values[index++];
    }
}
