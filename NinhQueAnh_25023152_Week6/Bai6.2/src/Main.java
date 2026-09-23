public class Main {
    public static void main(String[] args) {
        NotificationApp app;

        app= new EmailApp();
        app.notifyUser("hello nqa");

        app=new SmsApp();
        app.notifyUser("Hello NQA");
    }
}
