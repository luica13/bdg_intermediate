package Homework;

import java.util.*;

public class ArrayList<E> implements List<E> {
    private int index ;
    private Object [] arrayObject = new Object[20];
    public ArrayList(int index , Object [] arrayObject ){
        this.arrayObject =arrayObject;

    };

    public ArrayList() {
    }


    @Override
    public int size() {
        return index;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i <arrayObject.length ; i++) {
            if (arrayObject[i] == null){return true;}
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < arrayObject.length ; i++) {
            if (arrayObject[i]!= null){
                if (arrayObject[i].equals(o)){return true;}
            }else {return false;}}
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;

    }
    public class MyIterator <E> implements Iterator<Integer> {
        int index = 0;
       int result = 0;
        @Override
        public boolean hasNext() {
            if (index<size()){return true;}
            return false;
        }

        @Override

        public Integer next() {
            if (hasNext()){result = index;index++ ; return result;}
            return result;
        }

        @Override
        public void remove() {

        }
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
        //do not implement this
    }

    public <T> T[] toArray(T[] a) {

        return null;
    }

    @Override
    public boolean add(Object e) {

        Object[]newArrayObject = new Object[(int) (arrayObject.length*1.5)];
        for (int i = arrayObject.length; i <newArrayObject.length ; i++) {
            newArrayObject[i]=e; return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (o==null){return false;}
        int index = 0;
        Object []removedArray = new Object[arrayObject.length-1];
        for (int i = 0; i < arrayObject.length; i++) {
            if (arrayObject[i].equals(o)){removedArray[i]=arrayObject[i+1+index];index++;}else
            {removedArray[i]=arrayObject[i+index];}
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c.size()<=arrayObject.length ){
            Object[]newObject=c.toArray();
            for (int i = 0; i <newObject.length ; i++) {
                if (c.contains(arrayObject[i])){continue;}else{return false;}
            }
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {

        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {

        return false;
    }

    @Override
    public void clear() {
    for (int i = 0 ; i< arrayObject.length ; i++){
        arrayObject[i]=null;
    }
    }

    @Override
    public E get(int index) {
        E result = null;
        for (int i =0; i <arrayObject.length ;i++ )
        if (i == index){result = (E) arrayObject[i]; }
        return result;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {
        Object[]newArrayObject = new Object[(int) (arrayObject.length*1.5)];
        if (index >= size()-1){
            for (int i = 0; i < arrayObject.length; i++) {
                if (!(i==index)){
                    newArrayObject[i]=arrayObject[i];
                }else {
                    newArrayObject[i]=element;newArrayObject[i+1]=arrayObject[i];
                }
            }arrayObject = newArrayObject;
        }

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "index=" + index +
                ", arrayObject=" + Arrays.toString(arrayObject) +
                '}';
    }

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(0,10);
        integers.add(1,15);
        integers.add(2,20);
        System.out.println(integers);


    }

}
