public class Truck extends Vehicle {

    public Truck(String plate) {
        super(plate);
    }

    @Override
    public double calculateFee(int hours) {
        return 15 + hours * 4;
    }

    @Override
    public int calculateBonusPoints(int hours) {
        if (hours > 5) {
            return 2;
        }
        return 1;
    }
}
