import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            int type = Integer.parseInt(sc.nextLine());
            String name = sc.nextLine();
            String dob = sc.nextLine();
            String employeeId = sc.nextLine();

            if (type == 1) {
                double baseSalary = Double.parseDouble(sc.nextLine());
                double bonus = Double.parseDouble(sc.nextLine());
                double penalty = Double.parseDouble(sc.nextLine());

                employees[i] = new FullTimeEmployee(name, dob, employeeId,
                        baseSalary, bonus, penalty);
            } else if (type == 2) {
                double workingHours = Double.parseDouble(sc.nextLine());
                double hourlyRate = Double.parseDouble(sc.nextLine());

                employees[i] = new PartTimeEmployee(name, dob, employeeId,
                        workingHours, hourlyRate);
            }
        }

        System.out.println("BANG LUONG NHAN VIEN");
        for (Employee e : employees) {
            System.out.printf("%s - %s - %.2f%n",
                    e.getName(), e.getType(), e.calculateSalary());
        }

        sc.close();
    }
}