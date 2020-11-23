import java.util.ArrayList;
import java.util.List;

public class Channel {

    private List<Observer> observers = new ArrayList<>();
    private String title;

    public String getTitle() {
        return title;
    }

    public void uploadVideo(String title) {
        this.title = title;
        notifyAllObservers();
    }

    public void add(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}