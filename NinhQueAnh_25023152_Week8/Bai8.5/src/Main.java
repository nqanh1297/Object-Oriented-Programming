import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Order> orders = new ArrayList<>();

        orders.add(new StandardOrder(2, 10));
        orders.add(new ExpressOrder(1.5, 8));
        orders.add(new FragileOrder(3, 12));
        orders.add(new BulkyOrder(5, 20));

        for (Order o : orders) {
            System.out.println(o.getLabel() + " - Fee: " + o.getDeliveryFee());
        }
    }
}
