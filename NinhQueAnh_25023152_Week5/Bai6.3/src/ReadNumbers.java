import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataInputStream dis = null;

        try {
            System.out.print("Nhap ten tep can doc: ");
            String fileName = sc.nextLine();

            dis = new DataInputStream(new FileInputStream(fileName));

            while (true) {
                int x = dis.readInt();
                System.out.println(x);
            }

        } catch (EOFException e) {
            System.out.println("Da doc het du lieu.");
        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();
        } finally {
            try {
                if (dis != null) dis.close();
            } catch (IOException e) {
                System.out.println("Loi khi dong tep doc.");
            }
            sc.close();
            System.out.println("Program finished.");
        }
    }
}