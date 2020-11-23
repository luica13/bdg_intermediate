public class RussianObserver extends Observer {
    private String name;

    public RussianObserver(String name) {
        this.name = name;
    }

    public void subscribe(Channel channel) {
        this.channel = channel;
        this.channel.add(this);
    }

    @Override
    public void update() {
        System.out.println("Дорогой " + name + " новое видео загружено: " + channel.getTitle());
    }
}