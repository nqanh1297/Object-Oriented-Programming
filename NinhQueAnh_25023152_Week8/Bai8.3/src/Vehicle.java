abstract class Vehicle {
    protected String plate;
    protected String brand;

    public Vehicle(String plate, String brand) {
        this.plate = plate;
        this.brand = brand;
    }

    public String getInfo() {
        return getType() + " [" + plate + "] - " + brand;
    }

    protected abstract String getType();
}
