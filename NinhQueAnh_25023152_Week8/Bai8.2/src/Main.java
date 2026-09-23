public class Main {
    public static void main(String[] args) {
        String name = "Nguyen Van A";
        double baseSalary = 20_000_000;
        int workDays = 24;
        int totalDays = 26;
        double taxRate = 0.15;
        double bonus = 2_000_000;

        System.out.println("===== BEFORE REFACTOR =====");
        PayrollBeforeRefactor before = new PayrollBeforeRefactor();
        before.printPayroll(name, baseSalary, workDays, totalDays, taxRate, bonus);

        System.out.println();
        System.out.println("===== AFTER REFACTOR =====");
        PayrollAfterRefactor after = new PayrollAfterRefactor();
        after.printPayroll(name, baseSalary, workDays, totalDays, taxRate, bonus);
    }
}
