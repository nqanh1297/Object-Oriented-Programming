import java.util.*;

abstract class Product {
    protected String code;
    protected String name;

    public Product(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public abstract String getInfo();
}

class FoodProduct extends Product {
    private String expiryDate;

    public FoodProduct(String code, String name, String expiryDate) {
        super(code, name);
        this.expiryDate = expiryDate;
    }

    @Override
    public String getInfo() {
        return name + " - " + expiryDate;
    }
}

class ElectronicsProduct extends Product {
    private int warrantyMonths;

    public ElectronicsProduct(String code, String name, int warrantyMonths) {
        super(code, name);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String getInfo() {
        return name + " - " + warrantyMonths + " tháng bảo hành";
    }
}

class Warehouse<T extends Product> {
    private List<T> items;

    public Warehouse() {
        items = new ArrayList<>();
    }

    public void importItem(T item) {
        items.add(item);
    }

    public boolean exportItem(String code) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getCode().equals(code)) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    public void checkInventory() {
        for (T item : items) {
            System.out.println(item.getInfo());
        }
    }

    public List<T> getItems() {
        return items;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Warehouse<FoodProduct> foodWarehouse = new Warehouse<>();
        Warehouse<ElectronicsProduct> electronicsWarehouse = new Warehouse<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String code = sc.next();
            String name = sc.next();

            if (type.equals("F")) {
                String expiryDate = sc.next();
                foodWarehouse.importItem(new FoodProduct(code, name, expiryDate));
            } else if (type.equals("E")) {
                int warrantyMonths = sc.nextInt();
                electronicsWarehouse.importItem(new ElectronicsProduct(code, name, warrantyMonths));
            }
        }

        System.out.println("Kho thực phẩm:");
        foodWarehouse.checkInventory();

        System.out.println("Kho điện tử:");
        electronicsWarehouse.checkInventory();

        sc.close();
    }
}