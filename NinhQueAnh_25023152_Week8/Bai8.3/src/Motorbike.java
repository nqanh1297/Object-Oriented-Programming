class MotorBike extends FuelVehicle {
    public MotorBike(String plate, String brand) {
        super(plate, brand);
    }

    @Override
    protected String getType() {
        return "Xe máy";
    }
}
