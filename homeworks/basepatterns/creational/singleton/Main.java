package patterns.basepatterns.creational.singleton;

public class Main {
    public void getUsers() {
        System.out.println(FakeStorage.storage().users());
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.getUsers();
    }
}
