import java.io.*;
import java.net.*;

public class CommandServer {
    public static void main(String[] args) {
        int port = 5000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            // Cài đặt timeout 5 giây, nếu không ai kết nối sẽ ném ngoại lệ
            serverSocket.setSoTimeout(5000);
            System.out.println("Command Server đang lắng nghe trên TCP port " + port);

            Socket socket = serverSocket.accept(); // Đợi client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String command;

            while ((command = in.readLine()) != null) {
                if ("START".equals(command)) System.out.println("System initialized...");
                else if ("SHUTDOWN".equals(command)) System.out.println("System shutdown...");
            }
        } catch (SocketTimeoutException e) {
            System.out.println("Timeout: Không có Client nào tương tác trong 5s!");
        } catch (BindException e) {
            System.out.println("Lỗi Bind: Cổng " + port + " đang bị chiếm dụng bởi app khác!");
        } catch (IOException e) {
            System.out.println("Lỗi I/O: " + e.getMessage());
        }
    }
}