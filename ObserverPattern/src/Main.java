public class Main {
    public static void main(String[] args) {
        Channel channel = new Channel();

        ArmenianObserver armenian = new ArmenianObserver("Սամվել");
        AmericanObserver american = new AmericanObserver("Jack");
        RussianObserver russian = new RussianObserver("Павел");

        armenian.subscribe(channel);
        american.subscribe(channel);

        System.out.println("First video uploaded");
        channel.uploadVideo("Java Programming");
        System.out.println("Second video uploaded");
        channel.uploadVideo("Observer Pattern");

    }
}