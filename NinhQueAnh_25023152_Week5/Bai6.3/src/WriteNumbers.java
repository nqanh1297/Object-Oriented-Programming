import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataOutputStream dos=null;

        try {
            System.out.print("Nhap ten tep ghi du lieu:");
            String fileName=sc.nextLine();

            System.out.print("Nhap so luong so nguyen n:");
            int n= sc.nextInt();

            dos=new DataOutputStream(new FileOutputStream(fileName));

            for (int i=1;i<=n;i++) {
                System.out.print("Nhap so thu "+i+": ");
                int x=sc.nextInt();
                dos.writeInt(x);
            }
            System.out.println("Ghi du lieu thanh cong");
        }
        catch (IOException e) {
            System.out.println("I/O error");
            e.printStackTrace();
        }
        finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                System.out.println("Loi khi dong tep ghi");
            }
            sc.close();
            System.out.println("Program finished");
        }
        }
}
