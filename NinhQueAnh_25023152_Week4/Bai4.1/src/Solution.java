abstract class Shape {
    protected int x, y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void draw();
    public abstract void erase();

    public void moveTo(int newX, int newY) {
        erase();
        this.x = newX;
        this.y = newY;
        draw();
    }
}

class Circle extends Shape {

    public Circle(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw() {
        System.out.println("Vẽ hình tròn tại (" + x + ", " + y + ")");
    }

    @Override
    public void erase() {
        System.out.println("Xóa hình tròn tại (" + x + ", " + y + ")");
    }
}

class Square extends Shape {

    public Square(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw() {
        System.out.println("Vẽ hình vuông tại (" + x + ", " + y + ")");
    }

    @Override
    public void erase() {
        System.out.println("Xóa hình vuông tại (" + x + ", " + y + ")");
    }
}

public class Solution {
    public static void main(String[] args) {
        Circle circle = new Circle(10, 10);
        circle.moveTo(20, 20);
    }
}
