import java.util.ArrayList;
import java.util.List;

public class ParkingCustomer {
    private final String name;
    private final List<ParkingTicket> tickets = new ArrayList<>();

    public ParkingCustomer(String name) {
        this.name = name;
    }

    public void addTicket(ParkingTicket ticket) {
        tickets.add(ticket);
    }

    public String receipt() {
        StringBuilder result = new StringBuilder();
        result.append("Parking Receipt for ").append(name).append("\n");

        for (ParkingTicket ticket : tickets) {
            result.append(buildReceiptLine(ticket));
        }

        result.append("Total fee is ").append(calculateTotalFee()).append("\n");
        result.append("You earned ").append(calculateTotalBonusPoints()).append(" bonus points");

        return result.toString();
    }

    private String buildReceiptLine(ParkingTicket ticket) {
        return "\t" + ticket.getVehicle().getPlate() + "\t" + ticket.calculateFee() + "\n";
    }

    private double calculateTotalFee() {
        double total = 0;
        for (ParkingTicket ticket : tickets) {
            total += ticket.calculateFee();
        }
        return total;
    }

    private int calculateTotalBonusPoints() {
        int total = 0;
        for (ParkingTicket ticket : tickets) {
            total += ticket.calculateBonusPoints();
        }
        return total;
    }
}
