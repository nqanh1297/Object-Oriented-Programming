public class Student {
    private String id;
    private String name;
    private String email;
    private double gpa;
    public Student() {
        this.id="";
        this.name="";
        this.email="";
        this.gpa=0.0;
    }
    public Student(String id, String name) {
        this.id=id;
        this.name=name;
        this.email="";
        this.gpa=0.0;
    }
    public Student(Student other) {
        this.id=other.id;
        this.name=other.name;
        this.email=other.email;
        this.gpa=other.gpa;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public double getGpa() {
        return gpa;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setGpa(double gpa) {
        if (gpa>=0.0 && gpa<=4.0) {
            this.gpa=gpa;
        }
        else {
            System.out.println("Nhap sai du lieu");
        }
    }
    public void printInfo() {
        System.out.println("ID: "+id);
        System.out.println("Name: "+name);
        System.out.println("Email: "+email);
        System.out.println("GPA: "+gpa);
    }

    public static void main(String[] args) {
        Student s1= new Student();
        s1.setId("SV001");
        s1.setName("NQA");
        s1.setEmail("a@gmail.com");
        s1.setGpa(3.7);

        Student s2= new Student("SV002","NQB");
        s2.setEmail("b@gmail.com");
        s2.setGpa(3.6);

        Student s3= new Student(s2);
        s3.setId("SV003");
        s3.setName("NQC");
        s3.setGpa(-2);

        s1.printInfo();
        s2.printInfo();
        s3.printInfo();


    }
}
