package patterns.basepatterns.behavioral.observer;

public class JobSearch {
    public static void main(String[] args) {
        JavaDeveloperWebSite jobSite = new JavaDeveloperWebSite();

        jobSite.addVacancy("Junior Java developer position");
        jobSite.addVacancy("Middle Java developer position");

        Observer firstSubscriber = new Subscriber("Vardan Soghomonyan");
        Observer secondSubscriber = new Subscriber("Luiza Kharatyan");

        jobSite.addObserver(firstSubscriber);
        jobSite.addObserver(secondSubscriber);

        jobSite.addVacancy("Senior Java developer position");

        jobSite.removeVacancy("Junior Java developer position");
    }
}
