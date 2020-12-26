package main;

public class CustomLinkedList {

    //given a ListNode head, print all elements
    public void display(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode current = head;
        //loop each element till end of the list, and last node points to null
        while (current != null) {
            System.out.print(current.data + " --> ");
            //move to next element
            current = current.next;
        }
        System.out.print(current); // current will be null
    }

    //given a ListNode head, find out length of linked list
    public int length(ListNode head) {
        if (head == null) {
            return 0;
        }
        //create a count variables to hold length
        int count = 0;
        ListNode current = head;
        //loop each element and increment count till list ends
        while (current != null) {
            count++;
            //move to next node
            current = current.next;
        }
        return count;
    }

    //insert a node at the begin of linked list
    public ListNode insertAtBeginning(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            return newNode;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }

    //insert a node at the end of linked list
    public ListNode insertAtEnd(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            return newNode;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }


    private ListNode head;  // head node to hold the list

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        //25 --> 12 --> 8 --> 5 --> 17,    25 - as head node in linked list
        ListNode head = new ListNode(25);
        ListNode second = new ListNode(12);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(5);
        ListNode fifth = new ListNode(17);

        //attach them together
        head.next = second; // 25 --> 12
        second.next = third; // 25 --> 12 --> 8
        third.next = fourth; // 25 --> 12 --> 8 --> 5
        fourth.next = fifth; // 25 --> 12 --> 8 --> 5 --> 17

        CustomLinkedList singlyLinkedList = new CustomLinkedList();
        singlyLinkedList.display(head);
        System.out.println();
        System.out.println("length of linked list is: " + singlyLinkedList.length(head));

        ListNode newHead = singlyLinkedList.insertAtBeginning(head, 18);
        singlyLinkedList.display(newHead);

        System.out.println();
        ListNode newNode = singlyLinkedList.insertAtEnd(head, 38);
        singlyLinkedList.display(newNode);
    }
}

