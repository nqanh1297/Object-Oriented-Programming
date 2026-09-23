import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ReportTemplate original = new ReportTemplate(
                "Original Report",
                "Footer",
                Arrays.asList("Intro", "Body", "Conclusion")
        );

        ReportTemplate copy1 = original.clone();
        ReportTemplate copy2 = original.clone();

        copy1.setTitle("Report A");
        copy2.setTitle("Report B");

        original.show();
        copy1.show();
        copy2.show();
    }
}