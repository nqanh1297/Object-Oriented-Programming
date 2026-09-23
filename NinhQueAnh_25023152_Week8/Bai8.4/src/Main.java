public class Main {
    public static void main(String[] args) {
        Vehicle car = new Vehicle("30A-12345", Vehicle.CAR);
        Vehicle bike = new Vehicle("29B-22222", Vehicle.BIKE);
        Vehicle truck = new Vehicle("51C-99999", Vehicle.TRUCK);

        ParkingTicket t1 = new ParkingTicket(car, 4);
        ParkingTicket t2 = new ParkingTicket(bike, 5);
        ParkingTicket t3 = new ParkingTicket(truck, 6);

        ParkingCustomerBefore before = new ParkingCustomerBefore("Que Anh");
        before.addTicket(t1);
        before.addTicket(t2);
        before.addTicket(t3);

        ParkingCustomer after = new ParkingCustomer("Que Anh");
        after.addTicket(t1);
        after.addTicket(t2);
        after.addTicket(t3);

        System.out.println("===== BEFORE REFACTOR =====");
        System.out.println(before.receipt());

        System.out.println();
        System.out.println("===== AFTER REFACTOR =====");
        System.out.println(after.receipt());
    }
}