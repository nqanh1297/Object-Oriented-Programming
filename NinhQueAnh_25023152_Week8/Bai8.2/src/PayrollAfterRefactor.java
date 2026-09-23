public class PayrollAfterRefactor {

    private static final double SOCIAL_INSURANCE_RATE = 0.08;
    private static final double HEALTH_INSURANCE_RATE = 0.015;

    private static final double PERSONAL_DEDUCTION = 11_000_000;

    private static final double FIRST_TAX_BRACKET_LIMIT = 5_000_000;
    private static final double SECOND_TAX_BRACKET_LIMIT = 10_000_000;

    private static final double FIRST_TAX_RATE = 0.05;
    private static final double SECOND_TAX_RATE = 0.10;

    private static final double FIRST_TAX_BRACKET_FIXED_TAX = 250_000;
    private static final double SECOND_TAX_BRACKET_FIXED_TAX = 750_000;

    public void printPayroll(String name, double baseSalary,
                             int workDays, int totalDays,
                             double taxRate, double bonus) {

        double actualSalary = calculateActualSalary(baseSalary, workDays, totalDays);
        double insurance = calculateInsurance(actualSalary);
        double taxableIncome = calculateTaxableIncome(actualSalary, insurance);
        double tax = calculateTax(taxableIncome, taxRate);
        double netSalary = calculateNetSalary(actualSalary, insurance, tax, bonus);

        printHeader(name);
        printDetails(baseSalary, workDays, totalDays, actualSalary, insurance, tax, bonus, netSalary);
    }

    private double calculateActualSalary(double baseSalary, int workDays, int totalDays) {
        return baseSalary * workDays / totalDays;
    }

    private double calculateInsurance(double actualSalary) {
        double socialInsurance = actualSalary * SOCIAL_INSURANCE_RATE;
        double healthInsurance = actualSalary * HEALTH_INSURANCE_RATE;
        return socialInsurance + healthInsurance;
    }

    private double calculateTaxableIncome(double actualSalary, double insurance) {
        return actualSalary - insurance - PERSONAL_DEDUCTION;
    }

    private double calculateTax(double taxableIncome, double taxRate) {
        if (taxableIncome <= 0) {
            return 0;
        }

        if (taxableIncome <= FIRST_TAX_BRACKET_LIMIT) {
            return taxableIncome * FIRST_TAX_RATE;
        }

        if (taxableIncome <= SECOND_TAX_BRACKET_LIMIT) {
            return FIRST_TAX_BRACKET_FIXED_TAX
                    + (taxableIncome - FIRST_TAX_BRACKET_LIMIT) * SECOND_TAX_RATE;
        }

        return SECOND_TAX_BRACKET_FIXED_TAX
                + (taxableIncome - SECOND_TAX_BRACKET_LIMIT) * taxRate;
    }

    private double calculateNetSalary(double actualSalary, double insurance, double tax, double bonus) {
        return actualSalary - insurance - tax + bonus;
    }

    private void printHeader(String name) {
        System.out.println("=== BANG LUONG ===");
        System.out.println("Nhan vien: " + name);
    }

    private void printDetails(double baseSalary, int workDays, int totalDays,
                              double actualSalary, double insurance,
                              double tax, double bonus, double netSalary) {
        System.out.println("Luong co ban: " + baseSalary);
        System.out.println("Ngay cong: " + workDays + "/" + totalDays);
        System.out.println("Luong thuc te: " + actualSalary);
        System.out.println("Bao hiem: " + insurance);
        System.out.println("Thue TNCN: " + tax);
        System.out.println("Thuong: " + bonus);
        System.out.println("Thuc nhan: " + netSalary);
    }
}