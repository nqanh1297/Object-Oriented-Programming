public abstract class NotifierDecorator implements Notifier {
    private Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send(String msg){
        notifier.send(msg);
    }
}
