import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Bai2_EventDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));

        TextField txtName = new TextField();
        txtName.setPromptText("Nhập họ tên...");

        TextField txtAge = new TextField();
        txtAge.setPromptText("Nhập tuổi...");

        Button btnSubmit = new Button("Xác nhận");
        Label lblResult = new Label(); // Dùng để hiện thông báo lỗi/thành công

        // BẮT SỰ KIỆN CLICK NÚT VÀ VALIDATION
        btnSubmit.setOnAction(event -> {
            String name = txtName.getText().trim();
            String ageStr = txtAge.getText().trim();

            // Validation: Kiểm tra rỗng
            if (name.isEmpty() || ageStr.isEmpty()) {
                lblResult.setText("❌ Lỗi: Không được để trống thông tin!");
                lblResult.setStyle("-fx-text-fill: red;");
                return;
            }

            // Validation: Kiểm tra tuổi phải là số
            try {
                int age = Integer.parseInt(ageStr);
                lblResult.setText("✅ Xin chào " + name + " (" + age + " tuổi)!");
                lblResult.setStyle("-fx-text-fill: green;");
            } catch (NumberFormatException e) {
                lblResult.setText("❌ Lỗi: Tuổi phải là một con số!");
                lblResult.setStyle("-fx-text-fill: red;");
            }
        });

        root.getChildren().addAll(new Label("Họ tên:"), txtName, new Label("Tuổi:"), txtAge, btnSubmit, lblResult);

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.setTitle("Bài 2 - Event & Validation");
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}
