package patterns.basepatterns.structural.facade;

public class FacadeSample {
    private Shape circle;
    private Shape rectangle;

    public FacadeSample() {
        this.circle = new Circle();
        this.rectangle = new Rectangle();
    }

    public FacadeSample(Shape circle, Shape rectangle) {
        this.circle = circle;
        this.rectangle = rectangle;
    }

    public void printCircleArea() {
        circle.printArea();
    }
    public void printRectangleArea() {
        rectangle.printArea();
    }

    //public static void main(String[] args) {
       /* Shape shape;


        shape = new Circle();
        shape.printArea();

        shape = new Rectangle();
        shape.printArea();

        shape = new Triangle();
        shape.printArea();

        shape = new Square();
        shape.printArea();*/
}
