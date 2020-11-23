public class AmericanObserver extends Observer {
    private String name;

    public AmericanObserver(String name) {
        this.name = name;
    }

    public void subscribe(Channel channel) {
        this.channel = channel;
        this.channel.add(this);
    }

    @Override
    public void update() {
        System.out.println("Dear " + name + " new video is uploaded: " + channel.getTitle());
    }
}