package main;


import java.util.LinkedList;

public class CustomLinkedList<T> {
    Node head; // list head

    class Node {  //node - linked list
        final T data;
        Node next;

        Node(T d) {
            data = d;
        }
    }

    public int size() {
        if (this.head == null)
            return 0;
        else {
            int size = 1;
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
                size++;
            }
            return size;
        }
    }

    public Boolean add( T data) {
        // create new Node
        Node new_node = new Node(data);
        new_node.next = null;
        // if list empty
        if (this.head == null) {
            this.head = new_node;
        }
        //if list isn't empty
        else {
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }

        return true;
    }

    public Boolean add(int index, T data) {
        if(index < 0 || index >= size())
            throw new ArrayIndexOutOfBoundsException();
        else {
            Node new_node = new Node(data);
            Node last = this.head;
            if(index==0){
                new_node.next = this.head;
                this.head = new_node;
            }
            else {
                for (int i = 0; i < index - 1; i++) {
                    last = last.next;
                }
                new_node.next = last.next;
                last.next = new_node;
            }
        }

        return true;
    }

    public void addFirst( T data) {
        // create new Node
        Node new_node = new Node(data);
        new_node.next = null;
        // if list empty
        if (this.head == null) {
            this.head = new_node;
        }
        //if list isn't empty
        else {
            new_node.next = this.head;
            this.head = new_node;
        }
    }

    public void addLast( T data) {
        add(data);
    }

    public Boolean remove(int index) {
        if(index < 0 || index >= size())
            throw new ArrayIndexOutOfBoundsException();
        if(index==0){
            head = head.next;
        }
        else {
            Node last = this.head;
            for (int i = 0; i < index - 1; i++) {
                last = last.next;
            }
            last.next = last.next.next;
        }

        return true;
    }

    public Boolean removeFirst() {
        if(size() == 0)
            throw new IllegalStateException();
        head = head.next;

        return true;
    }

    public Boolean removeLast() {
        if(size() == 0)
            throw new IllegalStateException();
        if(size() == 1) {
            head = null;
        }
        else {
            Node last = this.head;
            for (int i = 0; i < size() - 2; i++) {
                last = last.next;
            }
            last.next = null;
        }
        return  true;
    }

    public T get(int index) {
        if(size() == 0)
            throw new IllegalStateException();
        if(size() == 1) {
            return head.data;
            //es pahy chpatkeracri vonc kareli a cloney veradzardznel
        }
        Node last = this.head;
        for (int i = 0; i < index ; i++) {
            last = last.next;
        }
        return  last.data;
    }

    public boolean contains(T check) {
        for (Node x = head; x.next != null; x = x.next) {
            if (check.equals(x.data))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        Node currNode = this.head;

        System.out.print("LinkedList: ");


        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        return "";
    }
}
