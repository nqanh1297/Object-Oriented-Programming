import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap Size: ");
        int size = sc.nextInt();
        sc.nextLine();
        ArrayList<Employee> List = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Nhap Du Lieu Doi Tuong: ");
            String line = sc.nextLine();
            String[] p = line.split(" ");
            if (p[0].equals("E")) {
                String name = p[1];
                double baseSalary = Double.parseDouble(p[2]);
                List.add(new Employee(name,baseSalary));
            }
            else if (p[0].equals("D")) {
                String name = p[1];
                double baseSalary = Double.parseDouble(p[2]);
                int overtimeHours = Integer.parseInt(p[3]);
                List.add(new Developer(name,baseSalary,overtimeHours));
            }
            else if (p[0].equals("T")) {
                String name = p[1];
                double baseSalary = Double.parseDouble(p[2]);
                int bugsFound = Integer.parseInt(p[3]);
                List.add(new Tester(name,baseSalary,bugsFound));
            }
            else{
                System.out.println("Khong Co Doi Tuong!");
            }
        }
        System.out.println("------DangXuLy------");
        for (Employee obj:List) {
            System.out.println(obj);
            if (obj instanceof Developer) {
                System.out.println("Tang Khoa Hoc AWS");
            } if (obj instanceof Tester) {
                System.out.println("Tang Tool Test");
            }
            System.out.println("----------");
        }
    }
}
