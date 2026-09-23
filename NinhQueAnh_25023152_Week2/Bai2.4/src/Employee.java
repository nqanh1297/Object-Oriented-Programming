public class Employee {
    private String name;
    private MyDate birthday;

    public Employee(String name, MyDate birthday) {
        this.name=name;
        this.birthday=birthday;
    }
    public Employee(Employee other) {
        this.name= other.name;
        this.birthday=new MyDate(other.birthday);
    }

    public String getName() {
        return name;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }
    public void printInfo() {
        System.out.println("Name: "+name);
        System.out.println("Birthday: ");
        birthday.printDate();
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("NQA",new MyDate(1,1,2000));
        Employee emp2 = new Employee(emp1);

        emp1.getBirthday().setDay(2);
        emp1.getBirthday().setMonth(2);
        emp1.getBirthday().setYear(2022);

        System.out.println("Thong tin emp1: ");
        emp1.printInfo();
        System.out.println("Thong tin emp2: ");
        emp2.printInfo();
    }
}
