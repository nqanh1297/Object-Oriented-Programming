import java.net.*;

public class SensorReceiver {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(6000)) {
            byte[] buffer = new byte[1024];
            System.out.println("Đang hóng dữ liệu thời tiết trên UDP port 6000...");

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet); // Nhận gói tin
                String receivedData = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Dữ liệu cảm biến: " + receivedData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
