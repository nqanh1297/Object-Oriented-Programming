public class Main {
    public static void main(String[] args) {
        UIFactory factory;

        String os = "nqa";

        if (os.equals("nqa")) {
            factory = new WindowsFactory();
        }
        else {
            factory = new MacFactory();
        }
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.render();
        checkbox.render();
    }
}
