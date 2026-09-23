import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Bai3_JDBCDemo {
    public static void main(String[] args) {
        // Thông tin kết nối MySQL
        String url = "jdbc:mysql://localhost:3306/uet_manager";
        String user = "root";
        String password = ""; // Điền pass nếu có

        try {
            // 1. Mở kết nối
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Kết nối Database thành công!");

            // 2. Thêm một sinh viên mới (INSERT)
            String insertSql = "INSERT INTO students (fullname, mssv) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSql);
            pstmt.setString(1, "Ninh Quế Anh");
            pstmt.setString(2, "20020001");
            pstmt.executeUpdate();
            System.out.println("✅ Đã thêm sinh viên vào CSDL.");

            // 3. Đọc dữ liệu ra (SELECT)
            System.out.println("\n--- DANH SÁCH SINH VIÊN TRONG CSDL ---");
            String selectSql = "SELECT * FROM students";
            PreparedStatement selectStmt = conn.prepareStatement(selectSql);
            ResultSet rs = selectStmt.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        " | Tên: " + rs.getString("fullname") +
                        " | MSSV: " + rs.getString("mssv"));
            }

            // 4. Đóng kết nối
            conn.close();
        } catch (Exception e) {
            System.err.println("❌ Lỗi JDBC: " + e.getMessage());
        }
    }
}
