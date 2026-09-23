import java.net.*;

public class SensorSender {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            String data = "Temp: 28°C, Humidity: 65%";
            byte[] buffer = data.getBytes();
            InetAddress address = InetAddress.getByName("localhost");

            // Gói dữ liệu ném thẳng vào port 6000
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 6000);
            socket.send(packet);
            System.out.println("Đã bắn dữ liệu UDP: " + data);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}