class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class CustomLinkedList {
    private Node head;
    private int size;

    public CustomLinkedList(){
        size = 0;
    }

    public void add(int data){
        Node temp = head;
        if(head == null) {
            head = new Node(data);
            size++;
            return;
        }

        while (temp.next != null)
            temp = temp.next;
        temp.next = new Node(data);
        size++;
    }
    public void remove(int data){
        Node temp = head;
        while (temp.next.data != data){
            temp = temp.next;
            if(temp.next == null)
                return;
        }
        temp.next = temp.next.next;
        size--;
    }
    public int getSize(){
        return size;
    }

    @Override
    public String toString(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        return "";
    }

    public static void main(String []arg){
        CustomLinkedList list = new CustomLinkedList();
        list.add(4);
        list.add(7);
        list.add(1);
        list.add(8);
        list.add(9);
        list.add(6);
        list.remove(7);
        System.out.println(list);
        System.out.println("List Size is " + list.getSize());
    }
}
