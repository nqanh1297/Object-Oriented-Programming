class Car extends FuelVehicle {
    public Car(String plate, String brand) {
        super(plate, brand);
    }

    @Override
    protected String getType() {
        return "Ô tô";
    }
}
