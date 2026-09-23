public class Main {
    public static void main(String[] args) {

        Vehicle car = new Car("30A-12345");
        Vehicle bike = new Bike("29B-22222");
        Vehicle truck = new Truck("51C-99999");

        ParkingTicket t1 = new ParkingTicket(car, 4);
        ParkingTicket t2 = new ParkingTicket(bike, 5);
        ParkingTicket t3 = new ParkingTicket(truck, 6);

        ParkingCustomer customer = new ParkingCustomer("Que Anh");

        customer.addTicket(t1);
        customer.addTicket(t2);
        customer.addTicket(t3);

        System.out.println(customer.receipt());
    }
}
