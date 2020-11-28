package patterns.basepatterns.structural.facade;

public class Rectangle  implements Shape{
    int a = 5;
    int b = 3;

    @Override
    public void printArea() {
        System.out.println(a * b);
    }
}
