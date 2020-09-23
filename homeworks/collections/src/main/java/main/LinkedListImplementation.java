package main;


public class LinkedListImplementation {
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

    public void addLast(int item){
        Node news = new Node();
        news.data = item;
        news.next = null;

        if (this.size > 0)

            this.tail.next = news;

        // dm update

        if (this.size == 0) {

            this.head = news;

            this.tail = news;

            this.size += 1;

        } else {

            this.tail = news;

            this.size += 1;

        }

    }
    public void addFirst (int item){
        Node news = new Node();
        news.data = item;
        news.next = null;
        news.next = this.head;
        if (this.size == 0){
            this.head=news;
            this.tail = news;
            this.size = size+1;
        }
        else {
            this.head = news;
            this.size++;
        }

    }
    public void addAt(int item,int idx) {

        if (idx < 0 || idx > this.size) {

            ;

        }

        if (idx == 0) {

            addFirst(item);

        } else if (idx == this.size) {

            addLast(item);

        } else {

            // create

            Node news = new Node();

            news.data = item;

            news.next = null;

            // attach

            Node nm1 = getNodeAt(idx - 1);

            Node np1 = nm1.next;

            nm1.next = news;

            news.next = np1;

            // dm

            this.size++;

        }

    }public int removeFirst() throws Exception {

        if (this.size == 0) {

            throw new Exception("LL is empty.");

        }

        Node temp = this.head;

        if (this.size == 1) {

            this.head = null;

            this.tail = null;

            this.size = 0;

        } else {

            this.head = this.head.next;

            this.size--;

        }

        return temp.data;

    }

    public int removeLast() throws Exception {

        if (this.size == 0) {

            throw new Exception("LL is empty.");

        }

        Node temp = this.tail;

        if (this.size == 1) {

            this.head = null;

            this.tail = null;

            this.size = 0;

        } else {

            Node sm2 = getNodeAt(this.size - 2);

            sm2.next = null;

            this.tail = sm2;

            this.size--;

        }

        return temp.data;

    }

    public int removeAt(int idx) throws Exception {

        if (this.size == 0) {

            throw new Exception("LL is empty.");

        }

        if (idx < 0 || idx >= this.size) {

            throw new Exception("Invalid Index.");

        }

        if (idx == 0) {

            return removeFirst();

        } else if (idx == this.size - 1) {

            return removeLast();

        } else {

            Node nm1 = getNodeAt(idx - 1);

            Node n = nm1.next;

            Node np1 = n.next;

            nm1.next = np1;

            this.size--;

            return n.data;

        }

    }public void display() {

        System.out.println("----------------------");

        Node temp = this.head;

        while (temp != null) {

            System.out.print(temp.data + " ");

            temp = temp.next;

        }

        System.out.println(".");

        System.out.println("----------------------");

    }
    public static void main(String[] args) throws Exception {
        LinkedListImplementation list = new LinkedListImplementation();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.display();
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.getAt(3));
        System.out.println(list.getNodeAt(3));
        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());
        list.display();
        list.addFirst(100);
        list.display();
        list.removeAt(2);
        list.addAt(300, 2);
        list.display();
    }

}



