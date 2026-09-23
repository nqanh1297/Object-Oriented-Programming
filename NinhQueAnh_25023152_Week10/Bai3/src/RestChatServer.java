import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class RestChatServer {
    // Quản lý ID và Tin nhắn
    private static int clientCounter = 1;
    private static final List<String> chatRoom = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int port = 8080;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        // Tạo các Endpoint (API)
        server.createContext("/join", new JoinHandler());
        server.createContext("/submit", new SubmitHandler());
        server.createContext("/messages", new MessagesHandler());

        server.setExecutor(null);
        server.start();
        System.out.println("🚀 REST API Chat Server đang chạy tại http://localhost:" + port);
    }

    // API 1: Tham gia phòng và nhận ID (GET /join)
    static class JoinHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("GET".equals(exchange.getRequestMethod())) {
                String newClientId = "Client-" + (clientCounter++);
                System.out.println("👋 Cấp ID mới: " + newClientId);

                sendResponse(exchange, 200, newClientId);
            }
        }
    }

    // API 2: Gửi tin nhắn (POST /submit)
    static class SubmitHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("POST".equals(exchange.getRequestMethod())) {
                InputStream is = exchange.getRequestBody();
                String message = new String(is.readAllBytes()); // Đọc nội dung client gửi

                chatRoom.add(message); // Lưu vào không gian chung
                System.out.println("📩 Đã nhận và broadcast: " + message);

                sendResponse(exchange, 200, "OK");
            }
        }
    }

    // API 3: Lấy danh sách tin nhắn (GET /messages)
    static class MessagesHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("GET".equals(exchange.getRequestMethod())) {
                // Ghép tất cả tin nhắn thành 1 chuỗi, cách nhau bằng dấu xuống dòng
                String allMessages = String.join("\n", chatRoom);
                sendResponse(exchange, 200, allMessages);
            }
        }
    }

    // Hàm hỗ trợ gửi trả kết quả về cho Client
    private static void sendResponse(HttpExchange exchange, int statusCode, String response) throws IOException {
        exchange.sendResponseHeaders(statusCode, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}