import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class RestChatClient {
    private static final String SERVER_URL = "http://localhost:8080";
    private static String myClientId = "";
    private static int lastMessageCount = 0; // Nhớ xem đã đọc đến dòng thứ mấy rồi

    public static void main(String[] args) {
        try {
            // Bước 1: Xin ID từ Server (Đăng ký tham gia phòng)
            myClientId = sendGetRequest(SERVER_URL + "/join");
            System.out.println("✅ Bạn đã tham gia phòng với tên: " + myClientId);

            // Bước 2: Bật 1 luồng chạy ngầm để liên tục lấy tin nhắn mới (Polling)
            startPollingThread();

            // Bước 3: Vòng lặp cho người dùng nhập tin nhắn gửi đi
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String input = scanner.nextLine();
                if ("exit".equalsIgnoreCase(input)) {
                    System.out.println("Đã thoát chat.");
                    System.exit(0);
                }

                // Gắn thẻ ID vào tin nhắn và đẩy lên Server
                String payload = "[" + myClientId + "]: " + input;
                sendPostRequest(SERVER_URL + "/submit", payload);
            }

        } catch (Exception e) {
            System.err.println("❌ Lỗi Client: " + e.getMessage());
        }
    }

    // --- CÁC HÀM HỖ TRỢ GỌI API ---

    // Luồng lặp đi lặp lại để kéo tin nhắn về (Mỗi 2 giây)
    private static void startPollingThread() {
        Thread pollingThread = new Thread(() -> {
            while (true) {
                try {
                    String response = sendGetRequest(SERVER_URL + "/messages");
                    if (!response.isEmpty()) {
                        String[] messages = response.split("\n");
                        // Chỉ in ra những tin nhắn mới mà mình chưa đọc
                        for (int i = lastMessageCount; i < messages.length; i++) {
                            // Không in lại tin nhắn do chính mình vừa gửi (tùy chọn)
                            if (!messages[i].startsWith("[" + myClientId + "]")) {
                                System.out.println(messages[i]);
                            }
                        }
                        lastMessageCount = messages.length; // Cập nhật mốc đã đọc
                    }
                    Thread.sleep(2000); // Đợi 2 giây rồi hỏi tiếp
                } catch (Exception e) {
                    // Bỏ qua lỗi vặt nếu server lag
                }
            }
        });
        pollingThread.setDaemon(true);
        pollingThread.start();
    }

    // Hàm gọi API chuẩn GET
    private static String sendGetRequest(String targetUrl) throws Exception {
        URL url = new URL(targetUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            content.append(line).append("\n");
        }
        in.close();
        conn.disconnect();
        return content.toString().trim();
    }

    // Hàm gọi API chuẩn POST (Có gửi kèm dữ liệu)
    private static void sendPostRequest(String targetUrl, String data) throws Exception {
        URL url = new URL(targetUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true); // Cho phép gửi body

        OutputStream os = conn.getOutputStream();
        os.write(data.getBytes());
        os.flush();
        os.close();

        conn.getResponseCode(); // Chạy lệnh này để đảm bảo request thực sự được gửi đi
        conn.disconnect();
    }
}
