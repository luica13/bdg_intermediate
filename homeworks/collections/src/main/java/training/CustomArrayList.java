package training;

import java.util.Collection;
import java.util.Iterator;

public class CustomArrayList<E> implements Collection<E> {

    private int minCapacity = 10;
    private int currentIndex;
    private Object[] elements;

    public CustomArrayList() {
        elements = new Object[minCapacity];
        currentIndex = 0;
    }

    public CustomArrayList(int minCapacity) {
        if (minCapacity > 0) {
            this.minCapacity = minCapacity;
        }
        elements = new Object[this.minCapacity];
        currentIndex = 0;
    }

    @Override
    public int size() {
        return currentIndex;
    }

    @Override
    public boolean isEmpty() {
        return currentIndex == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            return false;
        }
        for (int i = 0; i < elements.length; i++) {
            Object ob = elements[i];
            if (o.equals(ob))
                return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < currentIndex;
            }

            @Override
            public E next() {
                return (E) elements[index++];
            }
        };
    }


    @Override
    public Object[] toArray() {

        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {

        return null;
    }

    @Override
    public boolean add(E e) {
        if (e != null) {
            if (elements.length == currentIndex) {
                Object[] objects = new Object[elements.length];
                for (int i = 0; i < elements.length; i++) {
                    objects[i] = elements[i];
                }
                elements = new Object[(int) (minCapacity * 1.5)];
                for (int i = 0; i < elements.length; i++) {
                    elements[i] = objects[i];
                }
            }
            elements[currentIndex++] = e;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (o != null) {
            int index = -1;
            for (int i = 0; i < elements.length; i++) {
                if (elements[i].equals(o)) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                System.arraycopy(elements, index + 1, elements, index, elements.length - index);
                this.currentIndex--;
            }

        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c.size() > this.size()) {
            return false;
        }
        Object[] objects = c.toArray();
        for (int i = 0; i < objects.length; i++) {
            Object ob = objects[i];
            if (ob != null && !contains(ob))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c != null) {
            if (elements.length <= currentIndex + c.size()) {
                Object[] objects = new Object[elements.length];
                for (int i = 0; i < elements.length; i++) {
                    objects[i] = elements[i];
                }
                elements = new Object[currentIndex + c.size()];
                for (int i = 0; i < elements.length; i++) {
                    elements[i] = objects[i];
                }
            }
            Object[] objects = c.toArray();
            for (int i = 0; i < objects.length; i++) {
                Object ob = objects[i];
                this.add((E) ob);
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean removeAll(Collection<?> c) {
        Object[] objects = c.toArray();
        if (c.containsAll(this)) {
            for (int i = 0; i < objects.length; i++) {
                Object ob = objects[i];
                this.remove(ob);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int i = 0;
        boolean t = false;
        while (i < currentIndex) {
            if (!c.contains(elements[i])) {
                this.remove(i);
                t = true;
                continue;
            }
            i++;
        }
        return t;
    }

    @Override
    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
        currentIndex = 0;
    }
}