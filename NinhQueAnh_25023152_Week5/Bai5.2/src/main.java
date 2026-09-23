public class main {
    public static void main(String[] args) {
        CustomerQueue customerQueue = new CustomerQueue();
        MessageHistory messageHistory = new MessageHistory();

        Customer customerA = new Customer("C01", "Khach A");
        Customer customerB = new Customer("C02", "Khach B");

        Ticket ticketA = new Ticket("T01", "Hoi ve don hang", "29/03/2026 10:00");
        Ticket ticketB = new Ticket("T02", "Yeu cau hoan tien", "29/03/2026 10:05");

        System.out.println("Thong tin ticket A: " + ticketA);
        System.out.println("Thong tin ticket B: " + ticketB);
        System.out.println();

        customerQueue.addCustomer(customerA);
        customerQueue.addCustomer(customerB);
        customerQueue.displayQueue();
        System.out.println();

        Customer currentCustomer = customerQueue.processCustomer();
        System.out.println();

        if (currentCustomer != null) {
            messageHistory.sendMessage(new Message("M01", "Xin chao, toi co the ho tro gi cho ban?"));
            messageHistory.sendMessage(new Message("M02", "Don hang cua ban dang duoc xu ly."));
            messageHistory.sendMessage(new Message("M03", "Cam on ban da lien he."));
        }

        System.out.println();
        messageHistory.displayAllMessages();
        messageHistory.viewLastMessage();

        System.out.println();
        System.out.println("Nhan vien go sai 1 dong, thuc hien undo:");
        messageHistory.undoMessage();

        System.out.println();
        messageHistory.displayAllMessages();
        messageHistory.viewLastMessage();

        System.out.println();
        customerQueue.processCustomer();
        customerQueue.processCustomer();
    }
}

