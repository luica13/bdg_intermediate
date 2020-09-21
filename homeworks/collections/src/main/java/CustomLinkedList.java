package main;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CustomLinkedList<E> {

    private transient int size = 0;

    private transient Node<E> first;
    private transient Node<E> last;

    public CustomLinkedList() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        if (indexOf(o) != -1) {
            return true;
        }
        return false;
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        int index = 0;
        for (Node<E> currentNode = first; currentNode != null; currentNode = currentNode.next) {
            arr[index++] = currentNode.item;
        }
        return arr;
    }

    public boolean add(E e) {
        Node<E> lastElem = last;
        last = new Node<>(lastElem, e, null);
        if (lastElem == null) {
            first = last;
        } else {
            lastElem.next = last;
        }
        size++;
        return true;
    }

    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    public boolean addAll(Collection<? extends E> c) {
        for (E elem : c) {
            add(elem);
        }
        return true;
    }

    public void clear() {
        first = last = null;
        size = 0;
    }

    public E get(int index) {
        checkIndexPosition(index);
        Node<E> currentNode = findNode(index);
        return currentNode.item;
    }

    public E set(int index, E element) {
        checkIndexPosition(index);
        Node<E> currentNode = findNode(index);
        E item = currentNode.item;
        currentNode.item = element;
        return item;
    }

    public void add(int index, E element) {
        checkIndexPosition(index);
        Node<E> elem = findNode(index);
        Node<E> elemPrevious = elem.prev;
        Node<E> newNode = new Node<>(elemPrevious, element, elem);
        elemPrevious.next = newNode;
        elem.prev = newNode;
        size++;
    }

    public E remove(int index) {
        checkIndexPosition(index);
        Node<E> node = findNode(index);
        if (node == first) {
            first = node.next;
            first.prev = null;
        } else if (node == last) {
            last = node.prev;
            last.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
        return node.item;
    }

    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> currentNode = first; currentNode != null; currentNode = currentNode.next) {
                if (currentNode.item == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> currentNode = first; currentNode != null; currentNode = currentNode.next) {
                if (o.equals(currentNode.item)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        int index = size;
        if (o == null) {
            for (Node<E> currentNode = last; currentNode != null; currentNode = currentNode.prev) {
                index--;
                if (currentNode.item == null) {
                    return index;
                }

            }
        } else {
            for (Node<E> currentNode = last; currentNode != null; currentNode = currentNode.prev) {
                index--;
                if (o.equals(currentNode.item)) {
                    return index;
                }
            }
        }

        return -1;
    }


    private static class Node<E> {
        E item;
        CustomLinkedList.Node<E> next;
        CustomLinkedList.Node<E> prev;

        Node(CustomLinkedList.Node<E> prev, E element, CustomLinkedList.Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<E> findNode(int index) {
        Node<E> elem;
        if (index < size / 2) {
            elem = first;
            for (int i = 0; i < index; i++)
                elem = elem.next;
        } else {
            elem = last;
            for (int i = size - 1; i > index; i--)
                elem = elem.prev;
        }
        return elem;
    }

    private void checkIndexPosition(int index) {
        if (!isValidIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= size;
    }

    @Override
    public String toString() {
        String delimiter = ", ";
        StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append("CustomLinkedList: [");
        if (this.size > 0) {
            for (Node<E> currentNode = first; currentNode != null; currentNode = currentNode.next) {
                stringBuilder.append(currentNode.item);
                stringBuilder.append(delimiter);
            }
            int lastDelimiterIndex = stringBuilder.lastIndexOf(delimiter);
            stringBuilder.delete(lastDelimiterIndex, lastDelimiterIndex + 2);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


}

class TestCustomLinkedList {
    private static CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
    private static final String JAIL = "##########################################################################################";

    public static void main(String[] args) {
        testAddAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 3, 9, 10, 11, 15));
        testAddElement(20);
        testAddBySpecifiedIndex(4, 67);
        testIsEmpty();
        testSize();
        testRemoveObject(10);
        testRemoveByIndex(0);
        testIndexOf(8);
        testLastIndexOf(3);
        testContains(7);
        testGetByIndex(5);
        testToArray();
        testClear();
    }

    private static void testAddAll(List<Integer> integers) {
        System.out.println(JAIL);
        System.out.println("initializing CustomLinkedList with collection of elements");
        customLinkedList.addAll(integers);
        System.out.println(customLinkedList);
        System.out.println(JAIL);
    }

    private static void testAddElement(int num) {
        System.out.println(JAIL);
        System.out.println("Adding element: " + num + " at last");
        customLinkedList.add(num);
        System.out.println(customLinkedList);
        System.out.println(JAIL);
    }

    private static void testAddBySpecifiedIndex(int index, int element) {
        System.out.println(JAIL);
        System.out.println("Adding element: " + element + " at index: " + index);
        customLinkedList.add(index, element);
        System.out.println(customLinkedList);
        System.out.println(JAIL);
    }

    private static void testIsEmpty() {
        System.out.println(JAIL);
        System.out.print("Is CustomLinkedList empty: ");
        System.out.println(customLinkedList.isEmpty());
        System.out.println(JAIL);
    }

    private static void testSize() {
        System.out.println(JAIL);
        System.out.print("size of CustomLinkedList: ");
        System.out.println(customLinkedList.size());
        System.out.println(customLinkedList);
        System.out.println(JAIL);
    }

    private static void testRemoveObject(Integer value) {
        System.out.println(JAIL);
        System.out.println(customLinkedList);
        System.out.println("Removing element: " + value);
        customLinkedList.remove(value);
        System.out.println(customLinkedList);
        System.out.println(JAIL);
    }

    private static void testRemoveByIndex(int index) {
        System.out.println(JAIL);
        System.out.println(customLinkedList);
        System.out.println("Removing element by index: " + index);
        customLinkedList.remove(index);
        System.out.println(customLinkedList);
        System.out.println(JAIL);
    }

    private static void testIndexOf(Integer value) {
        System.out.println(JAIL);
        System.out.println("Testing index of: " + value);
        System.out.println(customLinkedList.indexOf(value));
        System.out.println(customLinkedList);
        System.out.println(JAIL);
    }

    private static void testContains(Integer value) {
        System.out.println(JAIL);
        System.out.print("Contains " + value + ":");
        System.out.println(customLinkedList.contains(value));
        System.out.println(customLinkedList);
        System.out.println(JAIL);
    }

    private static void testGetByIndex(int index) {
        System.out.println(JAIL);
        System.out.print("Get by index " + index + ": ");
        System.out.println(customLinkedList.get(index));
        System.out.println(customLinkedList);
        System.out.println(JAIL);
    }

    private static void testLastIndexOf(Integer value) {
        System.out.println(JAIL);
        System.out.print("last index of " + value + ":");
        System.out.println(customLinkedList.lastIndexOf(value));
        System.out.println(customLinkedList);
    }

    private static void testClear() {
        System.out.println(JAIL);
        System.out.println("Testing clear()");
        customLinkedList.clear();
        System.out.println(customLinkedList);
        System.out.println(JAIL);
    }

    private static void testToArray() {
        System.out.println(JAIL);
        System.out.println("Testing toArray()");
        Object[] arr = customLinkedList.toArray();
        System.out.println("Length of arr: " + arr.length);
        System.out.print("Size of CustomLinkedList: ");
        System.out.println(customLinkedList.size());
        System.out.println(JAIL);
    }
}
