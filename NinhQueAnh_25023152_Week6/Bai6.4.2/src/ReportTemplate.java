import java.util.ArrayList;
import java.util.List;
public class ReportTemplate implements Cloneable{
    private String title;
    private String footer;
    private List<String> sections;

    public ReportTemplate(String title, String footer, List<String> sections) {
        this.title = title;
        this.footer = footer;
        this.sections = sections;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void show() {
        System.out.println("Title: " + title);
        System.out.println("Footer: " + footer);
        System.out.println("Sections: " + sections);
    }
    @Override
    public ReportTemplate clone() {
        try {
            ReportTemplate copy = (ReportTemplate) super.clone();
            copy.sections = new ArrayList<>(this.sections);

            return copy;
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
