public class StudentManager {
    private Student student;
    private Course course;
    private GradeRecord gradeRecord;

    public StudentManager(Student student, Course course, GradeRecord gradeRecord) {
        this.student = student;
        this.course = course;
        this.gradeRecord = gradeRecord;
    }

    public double calculateFinalGrade() {
        return gradeRecord.calculateFinalGrade();
    }

    public String getAcademicStatus() {
        return gradeRecord.getAcademicStatus();
    }

    public void printTranscript() {
        TranscriptPrinter printer = new TranscriptPrinter();
        printer.print(student, course, gradeRecord);
    }
}
