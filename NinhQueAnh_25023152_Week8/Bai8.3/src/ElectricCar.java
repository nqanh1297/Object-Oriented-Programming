class ElectricCar extends Vehicle {
    private int batteryPercent;

    public ElectricCar(String plate, String brand) {
        super(plate, brand);
    }

    public void charge(int percent) {
        batteryPercent += percent;
    }

    @Override
    protected String getType() {
        return "Xe điện";
    }
}
