public class Ticket {
    private String id;
    private String content;
    private String timestamp;

    public Ticket(String id,String content,String timestamp) {
        this.id=id;
        this.content=content;
        this.timestamp=timestamp;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Ticket{id='" + id + "',content='" + content + "',timestamp='" + timestamp + "'}";
    }
}
