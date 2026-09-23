public class Main {
    public static void main(String[] args) {
        Vehicle motorBike = new MotorBike("29A1-12345", "Honda");
        Vehicle car = new Car("30B-67890", "Toyota");
        Vehicle electricCar = new ElectricCar("31C-99999", "VinFast");

        System.out.println(motorBike.getInfo());
        System.out.println(car.getInfo());
        System.out.println(electricCar.getInfo());
    }
}
