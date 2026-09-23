public class Transaction {
    private final String transactionId;
    private final double amount;
    private final String timestamp;

    public Transaction(String transactionId, double amount, String timestamp) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Transaction(Transaction other) {
        this.transactionId = other.transactionId;
        this.amount = other.amount;
        this.timestamp = other.timestamp;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Transaction{id='" + transactionId + "', amount=" + amount + ", timestamp='" + timestamp + "'}";
    }
}
