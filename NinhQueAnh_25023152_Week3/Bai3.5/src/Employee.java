abstract class Employee {
    protected String name;
    protected String dob;
    protected String employeeId;

    public Employee(String name, String dob, String employeeId) {
        this.name = name;
        this.dob = dob;
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public abstract double calculateSalary();

    public abstract String getType();
}