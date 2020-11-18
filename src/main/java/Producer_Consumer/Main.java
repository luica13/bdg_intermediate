package Producer_Consumer;

public class Main {
    public static void main(String...s)
    {
        Resource r=new Resource();
        Producer p=new Producer(r);
        Consumer c=new Consumer(r);
    }
}
