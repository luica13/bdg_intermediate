package patterns.basepatterns.structural.facade;

public class Square implements Shape{
    int a = 4;

    @Override
    public void printArea() {
        System.out.println(a * a);
    }
}
