public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println("Logger instances equal: " + (logger1 == logger2));

        logger1.logInfo("Application started");
        logger2.logError("Something went wrong");
    }
}