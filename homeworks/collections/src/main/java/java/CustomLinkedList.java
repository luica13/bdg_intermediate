package java;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



    public class CustomLinkedList<E> implements List<E> {


        private Node head;
        private int size = 0;


        public CustomLinkedList() {

        }

        @Override
        public int size() {
            return this.size;
        }

        @Override
        public boolean isEmpty() {
            return this.size == 0;
        }

        @Override
        public boolean contains(Object o) {
            if (head ==null){return false;}
            Node current = head;
            if (current.element.equals(o)){return true;}
            while (current.next!=null){
                current = current.next;
                if (current.element.equals(o)){
                    return true;
                }
            }
            return false;
        }

        @Override
        public Iterator<E> iterator() {
            Iterator iterator = new Iterator() {
                int index = 0;

                @Override
                public boolean hasNext() {
                    return index <= size;
                }

                @Override
                public Object next() {
                    index ++;

                    return get(index);
                }
            };
            return null;
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
            if (this.head == null) {
                this.head = new Node(null, e, null ,10);
                this.size = 1;
                return true;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }

            current.next = new Node(current, e, null , 10);
            this.size++;
            return true;
        }

        @Override
        public boolean remove(Object o) {
            Node current = head;
            if (current==null){return false;}
            if (current.element.equals(o)){current.next.previews=null;size--;}//return if you want to remove only 1 node
            while (current.next!=null){
                current = current.next;
                if (current.element.equals(o)){
                    current.previews.next=current.next;
                    size--;
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            int equalsCount =0;
            Node current =head;
            Iterator iterator = c.iterator();
            while (iterator.hasNext()){
                while (current.next !=null){
                    if (current.equals(iterator.hasNext())){equalsCount++;}
                }
            }
            return equalsCount==c.size();
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            Iterator<?> iterator = c.iterator();
            while (iterator.hasNext()){
                this.add(size, (E) iterator.next());
                size++;
            }
            return true;
        }

        @Override
        public boolean addAll(int index, Collection<? extends E> c) {
            int i = index;
            Iterator <?>iterator = c.iterator();
            while (iterator.hasNext()){
                add(i,(E)iterator.next());
                i++;
                size++;
            }
            return true;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            Node current = head;
            Iterator iterator = c.iterator();
            while (iterator.hasNext()){
                while (current.next!=null){
                    if (current.equals(iterator.next())){this.remove(current);size--;}
                }
            }
            return true;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {
            Node current = head;
            current=null;

        }

        @Override
        public E get(int index) {
            int currentIndex = 0;
            Node current = head;
            while (current!=null){
                current = current.next;
                currentIndex++;
                if (currentIndex==index){return current.element;}
            }
            return null;
        }

        @Override
        public E set(int index, E element) {
            int currentIndex = 0;
            Node current = head;
            while (current!=null){
                current = current.next;
                currentIndex++;
                if (currentIndex==index){
                    current.element = element;
                }
            }
            return element;
        }

        @Override
        public void add(int index, E element) {
            int currentIndex = 0;
            Node current = head;
            while (current!=null){
                currentIndex++;
                if (currentIndex == index){
                    current = new Node(current.previews,element ,current,50);
                }
                current = current.next; size++;
            }
        }

        @Override
        public E remove(int index) {
            int currentIndex = 0;
            Node current = head;
            while (current != null){
                current =current.next;
                currentIndex++;
                if (currentIndex==index){current.previews.next= current.next;
                size--;
                break;}

            }
            return null;
        }

        @Override
        public int indexOf(Object o) {
            Node current = head;
            int currentIndex = 0;
            while (current != null){
                if (current.equals(o)){
                    return currentIndex-1;
                }
                current = current.next;
                currentIndex++;
            }
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            Node current = head;
            int currentIndex = 0;
            while (current != null){
                current = current.next;
                currentIndex++;
            }
            return currentIndex-1;
        }

        @Override
        public ListIterator<E> listIterator() {
            return new ListIterator<E>() {
                @Override
                public boolean hasNext() {
                    return false;
                }

                @Override
                public E next() {
                    return null;
                }

                @Override
                public boolean hasPrevious() {
                    return false;
                }

                @Override
                public E previous() {
                    return null;
                }

                @Override
                public int nextIndex() {
                    return 0;
                }

                @Override
                public int previousIndex() {
                    return 0;
                }

                @Override
                public void remove() {

                }

                @Override
                public void set(E e) {

                }

                @Override
                public void add(E e) {




                }
            };
        }

        @Override
        public ListIterator<E> listIterator(int index) {
            return null;
        }

        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            return null;
        }

        public String toString() {
            if (size == 0) {
                return "[]";
            }

            StringBuilder  builder = new StringBuilder("[");

            Node current = head;
            while (current != null) {
                builder.append(current.element).append(", ");
                current = current.next;
            }
            builder.append("]");
            return builder.toString().replace(", ]", "]");
        }

        private class Node {
            E element;
            Node next;
            Node previews;
            int value;
            Node(Node previews, E element, Node next , int value) {
                this.previews = previews;
                this.element = element;
                this.next = next;
                this.value = value;
            }
        }

        public static void main(String[] args) {
            List<Integer> integers = new CustomLinkedList<>();
            integers.add(10);
            integers.add(20);
            integers.add(40);
            System.out.println(integers.contains(10));


        }
    }


