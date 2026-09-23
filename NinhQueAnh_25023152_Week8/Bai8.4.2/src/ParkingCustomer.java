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

        double totalFee = 0;
        int bonusPoints = 0;

        for (ParkingTicket ticket : tickets) {
            result.append("\t")
                    .append(ticket.getVehicle().getPlate())
                    .append("\t")
                    .append(ticket.calculateFee())
                    .append("\n");

            totalFee += ticket.calculateFee();
            bonusPoints += ticket.calculateBonusPoints();
        }

        result.append("Total fee is ").append(totalFee).append("\n");
        result.append("You earned ").append(bonusPoints).append(" bonus points");

        return result.toString();
    }
}
