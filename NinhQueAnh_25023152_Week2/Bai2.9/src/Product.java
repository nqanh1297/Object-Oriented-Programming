import java.util.Scanner;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private double discount;

    private static double taxRate = 0.1;
    private static double totalRevenue = 0.0;

    public Product(String name, double price, int quantity, double discount) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    public static void updateTaxRate(double newRate) {
        taxRate = newRate;
    }

    public double calculateFinalPrice() {
        return (price - discount) * (1 + taxRate);
    }

    public void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public void sell(int amount) {
        if (amount <= quantity) {
            double revenue = calculateFinalPrice() * amount;
            quantity -= amount;
            totalRevenue += revenue;
            System.out.println("Ban thanh cong " + amount + " san pham " + name);
            System.out.println("Doanh thu lan nay: " + revenue);
        } else {
            System.out.println("Khong du hang trong kho de ban " + name);
        }
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount);
        System.out.println("Final Price: " + calculateFinalPrice());
        System.out.println("-------------------");
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ten sp1: ");
        String name1 = sc.nextLine();
        System.out.print("Nhap gia sp1: ");
        double price1 = sc.nextDouble();
        System.out.print("Nhap so luong sp1: ");
        int quantity1 = sc.nextInt();
        System.out.print("Nhap giam gia sp1: ");
        double discount1 = sc.nextDouble();
        sc.nextLine();

        System.out.print("Nhap ten sp2: ");
        String name2 = sc.nextLine();
        System.out.print("Nhap gia sp2: ");
        double price2 = sc.nextDouble();
        System.out.print("Nhap so luong sp2: ");
        int quantity2 = sc.nextInt();
        System.out.print("Nhap giam gia sp2: ");
        double discount2 = sc.nextDouble();

        Product p1 = new Product(name1, price1, quantity1, discount1);
        Product p2 = new Product(name2, price2, quantity2, discount2);

        p1.printInfo();
        p2.printInfo();

        p1.sell(3);
        p2.sell(1);

        Product.updateTaxRate(0.08);
        System.out.println("Sau khi doi thue VAT:");
        p1.printInfo();
        p2.printInfo();

        p1.updateDiscount(10.0);
        System.out.println("Sau khi doi giam gia cua p1:");
        p1.printInfo();
        p2.printInfo();

        System.out.println("Tong doanh thu: " + Product.getTotalRevenue());

        sc.close();
    }
}
