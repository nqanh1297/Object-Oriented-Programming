public class Main {
    public static void main(String[] args) {

        Notifier notifier = new SMSNotifier(
                new FacebookNotifier(
                        new EmailNotifier()
                )
        );

        notifier.send("Hello World");
    }
}