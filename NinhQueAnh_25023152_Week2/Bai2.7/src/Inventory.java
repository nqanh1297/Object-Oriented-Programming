public class Inventory {

    private Product[] items;

    public Inventory(Product[] initialItems) {

        items = new Product[initialItems.length];

        for (int i = 0; i < initialItems.length; i++) {
            items[i] = new Product(initialItems[i]);
        }
    }

    public void printItems() {
        for (Product p : items) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {

        Product[] arr = {
                new Product(1, "Laptop", 1000),
                new Product(2, "Phone", 800)
        };

        Inventory kho = new Inventory(arr);

        arr[0].setPrice(5000);

        System.out.println("Array:");
        for (Product p : arr) {
            System.out.println(p);
        }

        System.out.println("Inventory:");
        kho.printItems();
    }
}