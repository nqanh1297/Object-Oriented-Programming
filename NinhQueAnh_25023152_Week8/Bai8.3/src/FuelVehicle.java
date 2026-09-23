abstract class FuelVehicle extends Vehicle {
    protected double fuelLevel;

    public FuelVehicle(String plate, String brand) {
        super(plate, brand);
    }

    public void refuel(double liters) {
        fuelLevel += liters;
    }
}