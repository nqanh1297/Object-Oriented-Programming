import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Bai4_AdvancedDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));

        TextField txtPhone = new TextField();
        txtPhone.setPromptText("Nhập số điện thoại (Chỉ nhận số)...");
        Label lblWarning = new Label();
        lblWarning.setStyle("-fx-text-fill: red;");

        Button btnProcess = new Button("Xử lý dữ liệu nặng (Hoặc bấm Ctrl+S)");
        ProgressIndicator loading = new ProgressIndicator();
        loading.setVisible(false); // Ẩn vòng xoay lúc đầu

        // 1. REAL-TIME VALIDATION (Xử lý sự kiện TextProperty)
        // Gõ tới đâu kiểm tra tới đó, nếu nhập chữ sẽ báo lỗi đỏ ngay
        txtPhone.textProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal.matches("\\d*")) {
                txtPhone.setStyle("-fx-border-color: red;");
                lblWarning.setText("Cảnh báo: Chỉ được nhập số!");
            } else {
                txtPhone.setStyle("");
                lblWarning.setText("");
            }
        });

        // 2. SỰ KIỆN NÚT BẤM KẾT HỢP ĐA LUỒNG (Task)
        btnProcess.setOnAction(e -> {
            loading.setVisible(true); // Hiện vòng xoay
            btnProcess.setDisable(true); // Khóa nút để khỏi bấm 2 lần

            // Tạo luồng chạy ngầm để không làm đơ giao diện
            Task<Void> backgroundTask = new Task<>() {
                @Override
                protected Void call() throws Exception {
                    Thread.sleep(2000); // Giả lập chạy mất 2 giây
                    return null;
                }
            };

            backgroundTask.setOnSucceeded(event -> {
                loading.setVisible(false);
                btnProcess.setDisable(false);
                lblWarning.setStyle("-fx-text-fill: green;");
                lblWarning.setText("✅ Xử lý hoàn tất!");
            });

            new Thread(backgroundTask).start();
        });

        root.getChildren().addAll(new Label("Số điện thoại:"), txtPhone, lblWarning, btnProcess, loading);

        Scene scene = new Scene(root, 350, 250);

        // 3. SỰ KIỆN BÀN PHÍM GLOBAL (Phím tắt Ctrl + S)
        KeyCombination shortcut = new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN);
        scene.setOnKeyPressed(event -> {
            if (shortcut.match(event)) {
                btnProcess.fire(); // Ra lệnh tự động bấm nút xử lý
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Bài 4 - Đa luồng & Sự kiện");
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}