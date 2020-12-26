package patterns.basepatterns.structural.facade;

public class Circle implements Shape{
    int radius = 5;
    double pi = 3.1415;

    @Override
    public void printArea() {
        System.out.println(pi * radius * radius);
    }

}
