import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Nhap so nguyen a:");
            int a=sc.nextInt();

            System.out.println("Nhap so nguyen b:");
            int b=sc.nextInt();

            int kq=a/b;
            System.out.println("Ket qua:" +kq);
        }
        catch (InputMismatchException e) {
            System.out.println("Loi: Ban phai nhap so nguyen");
        }
        catch (ArithmeticException e) {
            System.out.println("Loi: Khong the chia cho 0");
        }
        finally {
            System.out.println("Program finished.");
            sc.close();
        }
    }
}
