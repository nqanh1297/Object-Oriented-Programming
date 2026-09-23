import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // Chạy trên máy ảo local
        int port = 8080;

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("✅ Đã kết nối tới Server thành công!");

            // Luồng Đọc/Ghi với Server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Luồng đọc dữ liệu từ bàn phím người dùng
            Scanner scanner = new Scanner(System.in);
            String userInput;

            System.out.println("Nhập tin nhắn để gửi (Gõ 'exit' để thoát):");

            while (true) {
                System.out.print("> ");
                userInput = scanner.nextLine();

                if ("exit".equalsIgnoreCase(userInput)) {
                    break;
                }

                // Gửi lên Server
                out.println(userInput);

                // Nhận phản hồi từ Server và in ra màn hình
                String response = in.readLine();
                System.out.println(response);
            }
            System.out.println("Đã ngắt kết nối.");
        } catch (IOException e) {
            System.err.println("Lỗi Client: " + e.getMessage());
        }
    }
}