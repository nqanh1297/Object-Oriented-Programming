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

    public double calculateFee() {
        return vehicle.calculateFee(hours);
    }

    public int calculateBonusPoints() {
        return vehicle.calculateBonusPoints(hours);
    }
}
