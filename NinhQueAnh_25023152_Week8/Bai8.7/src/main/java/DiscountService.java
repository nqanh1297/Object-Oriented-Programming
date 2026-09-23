public class DiscountService {

    public static double calculateDiscount(double price, String memberType) {
        if (price < 0) {
            throw new IllegalArgumentException("Invalid price");
        }

        switch (memberType) {
            case "GUEST":
                return 0.0;
            case "MEMBER":
                return price < 100 ? 0.05 : 0.10;
            case "VIP":
                return price < 100 ? 0.15 : 0.20;
            default:
                throw new IllegalArgumentException("Invalid member type");
        }
    }
}