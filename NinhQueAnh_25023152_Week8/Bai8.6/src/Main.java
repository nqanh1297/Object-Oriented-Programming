public class Main {
    public static void main(String[] args) {
        Student student = new Student("S001", "Nguyen Van A", 3.4);
        Course course = new Course("INT2204", "Lap trinh nang cao", 3);
        GradeRecord gradeRecord = new GradeRecord(7.5, 8.0, 9.0);

        StudentManager manager = new StudentManager(student, course, gradeRecord);

        manager.printTranscript();
    }
}
