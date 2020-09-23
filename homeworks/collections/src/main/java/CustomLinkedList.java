package main;

public class CustomLinkedList {

}public class LinkedListImplementation {
    public class Node {
        int data;
        Node next;
    }
    public Node head;
    public Node tail;
    public int size;
    public int size(){
        return this.size;

    }

    public int getFirst() {
        return this.head.data;
    }
    public int getLast(){
        return this.tail.data;

    }
    public int getAt(int idx){
        Node temp = this.head;
        for (int i = 1; i <= idx; i++){
            temp = temp.next;

        }
        return temp.data;
    }
    Node getNodeAt(int idx){
        Node temp = this.head;
        for (int i = 1; i <= idx; i++){
            temp = temp.next;

        }
        return temp;

    }

}
