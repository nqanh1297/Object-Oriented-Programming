import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        int port = 8080; // Cổng kết nối

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("✅ Echo Server đang chạy trên cổng " + port + "...");

            // Lắng nghe và chờ Client kết nối (Chỉ nhận 1 Client)
            Socket socket = serverSocket.accept();
            System.out.println("🤝 Có Client vừa kết nối!");

            // Tạo luồng Đọc/Ghi
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            // Đọc tin nhắn từ Client và phản hồi (Echo) ngay lập tức
            while ((message = in.readLine()) != null) {
                System.out.println("Client nói: " + message);
                out.println("Server Echo: " + message); // Gửi trả lại đúng câu đó
            }

            System.out.println("❌ Client đã ngắt kết nối.");
        } catch (IOException e) {
            System.err.println("Lỗi Server: " + e.getMessage());
        }
    }
}