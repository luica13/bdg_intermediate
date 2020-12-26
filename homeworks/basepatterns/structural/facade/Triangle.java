package patterns.basepatterns.structural.facade;

public class Triangle implements Shape{
    int a = 5;
    int b = 4;

    @Override
    public void printArea() {
        System.out.println((a * b) / 2);
    }

}
