import java.io.*;
import java.net.*;

public class CommandClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            out.println("START");
            Thread.sleep(1000);
            out.println("SHUTDOWN");
            System.out.println("Đã gửi lệnh TCP thành công.");

        } catch (ConnectException e) {
            System.err.println("Error: Remote server is offline! (TCP từ chối kết nối)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}