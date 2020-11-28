package patterns.basepatterns.structural.facade;

public class Main {
    public static void main(String[] args) {
        FacadeSample facadeSample = new FacadeSample();
        facadeSample.printCircleArea();
        System.out.println("------------");
        facadeSample.printRectangleArea();
    }
}
