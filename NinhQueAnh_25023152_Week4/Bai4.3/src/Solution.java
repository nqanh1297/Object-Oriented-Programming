import java.util.*;

interface IWorkable {
    void work();
}

abstract class Employee implements IWorkable {
    protected String id;
    protected String name;
    protected double baseSalary;

    public Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculatePay();
}

class OfficeWorker extends Employee {

    public OfficeWorker(String id, String name, double baseSalary) {
        super(id, name, baseSalary);
    }

    @Override
    public double calculatePay() {
        return baseSalary;
    }

    @Override
    public void work() {
        System.out.println("Soạn thảo văn bản");
    }
}

class Technician extends Employee {
    private int overtimeHours;

    public Technician(String id, String name, double baseSalary, int overtimeHours) {
        super(id, name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculatePay() {
        return baseSalary + overtimeHours * 20000;
    }

    @Override
    public void work() {
        System.out.println("Lắp đặt thiết bị");
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Employee> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equals("O")) {
                list.add(new OfficeWorker(id, name, salary));
            } else if (type.equals("T")) {
                int overtime = sc.nextInt();
                list.add(new Technician(id, name, salary, overtime));
            }
        }

        for (Employee e : list) {
            System.out.println(e.name + " - Pay: " + e.calculatePay());
            e.work();
            System.out.println();
        }
    }
}