public class Product {

    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(Product other) {
        this.id = other.id;
        this.name = other.name;
        this.price = other.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return id + " " + name + " " + price;
    }
}