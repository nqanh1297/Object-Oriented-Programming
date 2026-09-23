public class PayrollBeforeRefactor {

    public void printPayroll(String name, double baseSalary,
                             int workDays, int totalDays,
                             double taxRate, double bonus) {
        System.out.println("=== BANG LUONG ===");
        System.out.println("Nhan vien: " + name);

        double actualSalary = baseSalary * workDays / totalDays;

        double insurance = actualSalary * 0.08 + actualSalary * 0.015;

        double taxableIncome = actualSalary - insurance - 11000000;
        double tax = 0;
        if (taxableIncome > 0) {
            if (taxableIncome <= 5000000) {
                tax = taxableIncome * 0.05;
            } else if (taxableIncome <= 10000000) {
                tax = 250000 + (taxableIncome - 5000000) * 0.10;
            } else {
                tax = 750000 + (taxableIncome - 10000000) * taxRate;
            }
        }

        double netSalary = actualSalary - insurance - tax + bonus;

        System.out.println("Luong co ban: " + baseSalary);
        System.out.println("Ngay cong: " + workDays + "/" + totalDays);
        System.out.println("Luong thuc te: " + actualSalary);
        System.out.println("Bao hiem: " + insurance);
        System.out.println("Thue TNCN: " + tax);
        System.out.println("Thuong: " + bonus);
        System.out.println("Thuc nhan: " + netSalary);
    }
}
