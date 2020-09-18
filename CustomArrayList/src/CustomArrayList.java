import java.lang.reflect.Array;
import java.util.Arrays;

class ArrayListCustom<E> {

    private static final int INITIAL_CAPACITY = 10;
    private int size = 0;
    private Object elementData[] = {};

    public ArrayListCustom() {
        elementData = new Object[INITIAL_CAPACITY];
    }
    
    public ArrayListCustom(int capacity){
        elementData=new Object[capacity];
    }

    public void add(E e) {
        if (size == elementData.length) {
            ensureCapacity();
        }
        elementData[size++] = e;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + index);
        }
        return (E) elementData[index];
    }

    public Object remove(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + index);
        }

        Object removedElement = elementData[index];
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;

        return removedElement;
    }

    private void ensureCapacity() {
        int newIncreasedCapacity = elementData.length + elementData.length/2;
        elementData = Arrays.copyOf(elementData, newIncreasedCapacity);
    }


    public void printList() {
        System.out.print("Printing the list ");
        for (int i = 0; i < size; i++) {
            System.out.print(elementData[i] + " ");
        }
    }

}

public class CustomArrayList {

    public static void main(String... a) {
        ArrayListCustom<Integer> list = new ArrayListCustom<>();
        list.add(10);
        list.add(2);
        list.add(7);
        list.add(9);
        list.add(5);
        list.add(8);

        list.printList();
        System.out.println("\nElement at index in custom ArrayList " + 1 + " is " + list.get(1));

        System.out.println("Removed element "+ list.remove(1));

        System.out.println("\nPrinting ArrayList again after removal at index 1");

        list.printList();
    }

}