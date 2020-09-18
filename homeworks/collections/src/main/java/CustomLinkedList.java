package main;

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class CustomLinkedList {
    Node head;

    public void add(int data){
        Node temp;
        if(head == null) {
            head = new Node(data);
            return;
        }
        temp = head;
        while (temp.next != null)
            temp = head.next;
        temp.next = new Node(data);
    }
    public void print(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public static void main(String []arg){
        CustomLinkedList list = new CustomLinkedList();
        list.add(4);
        list.add(7);
        list.add(1);
        list.print();
    }
}
