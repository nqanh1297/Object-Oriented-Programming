public class BankAccount {
    private final String accountNumber;
    private double balance;
    private String ownerName;
    public BankAccount(String accountNumber, String ownerName){
        this.accountNumber=accountNumber;
        this.ownerName=ownerName;
        this.balance=0;
    }
    public BankAccount(String accountNumber, String ownerName, double balance ) {
        this.accountNumber=accountNumber;
        this.ownerName=ownerName;
        if(balance<0){
            System.out.println("So du khong họp le, dat =0");
            this.balance=0;
        }
        else {
            this.balance=balance;
        }
    }
    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
        }
    }
    public boolean withdraw(double amount) {
        if( amount>0 && amount<=balance) {
            balance-=amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("123456","NQA");
        acc.deposit(100);
        System.out.println("So du: " + acc.getBalance());
        acc.withdraw(300);
        System.out.println("So du sau rut: "+ acc.getBalance());
        boolean ok = acc.withdraw(1000);
        System.out.println("Rut qua so du: "+ ok);
    }
}
