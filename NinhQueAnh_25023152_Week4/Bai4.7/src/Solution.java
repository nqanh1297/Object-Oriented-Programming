import java.util.*;

class Student {
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + String.format("%.1f", gpa);
    }
}

@FunctionalInterface
interface Operation<T> {
    T execute(T a, T b);
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String id = sc.next();
            String name = sc.next();
            double gpa = sc.nextDouble();
            students.add(new Student(id, name, gpa));
        }

        students.removeIf(student -> student.getGpa() < 5.0);
        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));

        for (Student s : students) {
            System.out.println(s);
        }

        Operation<Double> add = (a, b) -> a + b;
        Operation<Double> sub = (a, b) -> a - b;
        Operation<Double> mul = (a, b) -> a * b;
        Operation<Double> div = (a, b) -> a / b;

        double x = 10.0, y = 2.0;

        System.out.println("Add: " + add.execute(x, y));
        System.out.println("Sub: " + sub.execute(x, y));
        System.out.println("Mul: " + mul.execute(x, y));
        System.out.println("Div: " + div.execute(x, y));

        sc.close();
    }
}