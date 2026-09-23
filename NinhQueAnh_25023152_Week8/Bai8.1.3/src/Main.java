public class Main {
    public static void main(String[] args) {
        AreaCalculator calculator = new AreaCalculator();

        System.out.println(calculator.getArea(new Rectangle(4, 5)));
        System.out.println(calculator.getArea(new Triangle(4, 5)));
        System.out.println(calculator.getArea(new Circle(4)));
    }
}
