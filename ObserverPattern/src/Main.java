public class Main {
    public static void main(String[] args) {

        Channel channel = new Channel();
        ArmenianObserver armenian = new ArmenianObserver("Սամվել");
        AmericanObserver american = new AmericanObserver("Jack");
        RussianObserver russian = new RussianObserver("Павел");

        armenian.subscribe(channel);
        american.subscribe(channel);
        russian.subscribe(channel);

        System.out.println("\nFirst video uploaded");
        sleep(400L);
        channel.uploadVideo("Java Programming");

        sleep(1000L);
        System.out.println("\nSecond video uploaded");
        sleep(400L);
        channel.uploadVideo("Observer Pattern");
        sleep(1000L);

    }

    private static void sleep(long milliseconds ) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}