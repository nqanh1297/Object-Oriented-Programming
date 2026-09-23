public class FeeCalculator {
    private static final double MEMBER_DISCOUNT_RATE = 0.9;

    public double calculateFee(String t, int hours, double rate, boolean isMember) {
        double fee = hours * rate;
        if (isMember) {
            fee = fee * MEMBER_DISCOUNT_RATE;
        }
        return fee;
    }
}
