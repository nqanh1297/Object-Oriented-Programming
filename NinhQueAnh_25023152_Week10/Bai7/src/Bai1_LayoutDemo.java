import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Bai1_LayoutDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        // 1. VBox: Layout chính xếp các phần tử từ trên xuống dưới
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        Label title = new Label("THÔNG TIN SINH VIÊN");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // 2. GridPane: Layout dạng lưới để làm Form nhập liệu
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(15);
        grid.setAlignment(Pos.CENTER);

        grid.add(new Label("Họ và Tên:"), 0, 0);
        grid.add(new TextField(), 1, 0);

        grid.add(new Label("Mã SV:"), 0, 1);
        grid.add(new TextField(), 1, 1);

        // 3. HBox: Layout xếp ngang cho các nút bấm
        HBox buttonBox = new HBox(15);
        buttonBox.setAlignment(Pos.CENTER);
        Button btnSave = new Button("Lưu");
        Button btnClear = new Button("Xóa trắng");
        buttonBox.getChildren().addAll(btnSave, btnClear);

        // Gắn tất cả vào VBox chính
        root.getChildren().addAll(title, grid, buttonBox);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Bài 1 - JavaFX Layouts");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}