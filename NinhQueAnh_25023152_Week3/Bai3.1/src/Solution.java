class Person {
    String name;
    String dob;

    public Person(String name) {
        this.name=name;
        System.out.println("1. Person is created");
    }
}

class Employee extends Person {
    double salary;

    public Employee() {
        super("Unknow");
        System.out.println("2. Employee is created");
    }
}

class Manager extends Employee {
    String departments;

    public Manager() {
        System.out.println("3. Manager is created");
    }
}
public class Solution {
    public static void main(String[] args) {
        Manager m = new Manager();
    }
}
