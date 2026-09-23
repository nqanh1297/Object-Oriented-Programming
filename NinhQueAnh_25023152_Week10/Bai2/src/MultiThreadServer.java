import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MultiThreadServer {
    private static final int PORT = 8080;

    // Hàm ghi log xịn xò (In ra thời gian + Nội dung)
    public static void log(String level, String message) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("[" + time + "] [" + level + "] " + message);
    }

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            log("INFO", "Multi-Thread Server đang chạy trên cổng " + PORT);

            // Vòng lặp vô hạn để liên tục đón các Client mới
            while (true) {
                Socket clientSocket = serverSocket.accept();
                String clientIP = clientSocket.getInetAddress().getHostAddress();
                log("INFO", "Bắt tay thành công với Client từ IP: " + clientIP);

                // Giao Client này cho một nhân viên (Thread) riêng chăm sóc
                ClientHandler handler = new ClientHandler(clientSocket);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            log("ERROR", "Lỗi khởi động Server: " + e.getMessage());
        }
    }

    // Class nhân viên (Thread) phục vụ từng Client
    private static class ClientHandler implements Runnable {
        private final Socket socket;
        private final String clientIP;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            this.clientIP = socket.getInetAddress().getHostAddress();
        }

        @Override
        public void run() {
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {
                String message;
                // Liên tục đọc tin nhắn từ Client này
                while ((message = in.readLine()) != null) {
                    log("MSG", "Nhận từ " + clientIP + ": " + message);

                    // Xử lý và gửi trả lại (Echo)
                    out.println("Server nhận được: " + message);
                    log("INFO", "Đã phản hồi cho " + clientIP);
                }
            } catch (IOException e) {
                log("WARNING", "Lỗi kết nối với " + clientIP + ": " + e.getMessage());
            } finally {
                try {
                    socket.close();
                    log("INFO", "Client " + clientIP + " đã ngắt kết nối.");
                } catch (IOException e) {
                    log("ERROR", "Không thể đóng socket: " + e.getMessage());
                }
            }
        }
    }
}
