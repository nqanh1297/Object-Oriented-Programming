public class Account {
    private String accountId;
    private double balance;
    private Transaction[] history;
    private int size;

    public Account(String accountId, double balance, Transaction[] history) {
        this.accountId = accountId;
        this.balance = balance;
        this.history = new Transaction[Math.max(10, history.length + 5)];
        this.size = 0;

        for (Transaction t : history) {
            this.history[this.size++] = new Transaction(t);
        }
    }

    public void addTransaction(Transaction t) {
        if (size == history.length) {
            Transaction[] newHistory = new Transaction[history.length * 2];
            for (int i = 0; i < history.length; i++) {
                newHistory[i] = history[i];
            }
            history = newHistory;
        }
        history[size++] = new Transaction(t);
    }

    public Transaction[] getHistory() {
        Transaction[] copy = new Transaction[size];
        for (int i = 0; i < size; i++) {
            copy[i] = new Transaction(history[i]);
        }
        return copy;
    }

    public void printHistory() {
        for (int i = 0; i < size; i++) {
            System.out.println(history[i]);
        }
    }

    public static void main(String[] args) {
        Transaction t1 = new Transaction("T01", 1000, "2026-03-09 10:00");
        Transaction t2 = new Transaction("T02", 500, "2026-03-09 11:00");

        Account acc = new Account("ACC01", 5000, new Transaction[]{t1, t2});

        Transaction[] hacked = acc.getHistory();
        hacked[0] = new Transaction("HACK", 999999, "fake-time");

        System.out.println("Lich su trong Account:");
        acc.printHistory();

        System.out.println("Lich su da lay ra ngoai:");
        for (Transaction t : hacked) {
            System.out.println(t);
        }
    }
}
