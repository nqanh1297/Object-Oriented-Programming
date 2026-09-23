import java.util.Stack;
public class MessageHistory {
    private Stack<Message> history;
    public MessageHistory(){
        history = new Stack<>();
    }
    public void sendMessage (Message message) {
        history.push(message);
        System.out.println("Tin nhan da duoc gui:"+message);
    }
    public Message undoMessage() {
        if (history.isEmpty()) {
            System.out.println("Khong co tin nhan de undo");
            return null;
        }
        Message removed = history.pop();
        System.out.println("Da undo tin nhan:"+removed);
        return removed;
    }
    public void viewLastMessage() {
        if (history.isEmpty()) {
            System.out.println("Khong co tin nhan nao trong lich su");
        }
        else {
            System.out.println("Tin nhan gan nhat:"+history.peek());
        }
    }
    public void displayAllMessages() {
        System.out.println("Lich su doan chat:"+history);
    }
}
