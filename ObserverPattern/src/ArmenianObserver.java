public class ArmenianObserver extends Observer {
    private String name;

    public ArmenianObserver(String name) {
        this.name = name;
    }

    public void subscribe(Channel channel) {
        this.channel = channel;
        this.channel.add(this);
    }

    @Override
    public void update() {
        System.out.println("Հարգարժան " + name + " նոր տեսահոլովակը ալիքում է: " + channel.getTitle());
    }
}