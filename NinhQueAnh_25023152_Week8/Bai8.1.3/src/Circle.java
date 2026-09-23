class Circle implements Shape {
    private static final double PI = 3.14159;
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return PI * radius * radius;
    }
}
