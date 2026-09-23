import java.util.LinkedList;
import java.util.Queue;
public class CustomerQueue {
    private Queue<Customer> queue;

    public CustomerQueue() {
        queue = new LinkedList<>();
    }
    public void addCustomer(Customer customer) {
        queue.offer(customer);
        System.out.println("Da them vao hang doi:"+customer);
    }
    public Customer processCustomer() {
        if(queue.isEmpty()) {
            System.out.println("Khong con khach de doi.");
            return null;
        }
        Customer customer = queue.poll();
        System.out.println("Dang xu li khach hang:"+ customer);
        return customer;
    }
    public void displayQueue() {
        System.out.println("Hang doi hien tai:"+queue);
    }
}
