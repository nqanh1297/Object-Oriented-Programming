public class ParkingTicket {
    private final Vehicle vehicle;
    private final int hours;

    public ParkingTicket(Vehicle vehicle, int hours) {
        this.vehicle = vehicle;
        this.hours = hours;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getHours() {
        return hours;
    }

    public double calculateFee() {
        switch (vehicle.getType()) {
            case Vehicle.CAR:
                return calculateCarFee();
            case Vehicle.BIKE:
                return calculateBikeFee();
            case Vehicle.TRUCK:
                return calculateTruckFee();
            default:
                return 0;
        }
    }

    public int calculateBonusPoints() {
        if (vehicle.getType() == Vehicle.TRUCK && hours > 5) {
            return 2;
        }
        return 1;
    }

    private double calculateCarFee() {
        double fee = 10;
        if (hours > 2) {
            fee += (hours - 2) * 3;
        }
        return fee;
    }

    private double calculateBikeFee() {
        double fee = 5;
        if (hours > 3) {
            fee += (hours - 3) * 2;
        }
        return fee;
    }

    private double calculateTruckFee() {
        return 15 + hours * 4;
    }
}
