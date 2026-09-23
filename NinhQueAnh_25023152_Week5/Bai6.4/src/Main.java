import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();
        String fileName = "students.dat";

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
            while (true) {
                System.out.print("Nhap id sinh vien (nhap END de dung): ");
                String id = sc.nextLine();

                if (id.equalsIgnoreCase("END")) {
                    break;
                }

                System.out.print("Nhap ten sinh vien: ");
                String name = sc.nextLine();

                System.out.print("Nhap GPA: ");
                double gpa = Double.parseDouble(sc.nextLine());

                Student st = new Student(id, name, gpa);
                studentList.add(st);
            }

            oos = new ObjectOutputStream(new FileOutputStream(fileName));

            for (Student st : studentList) {
                oos.writeObject(st);
            }

            System.out.println("Ghi danh sach sinh vien vao file thanh cong.");

            oos.close();
            oos = null;

            ois = new ObjectInputStream(new FileInputStream(fileName));

            System.out.println("\nDanh sach sinh vien doc tu file:");

            while (true) {
                Student st = (Student) ois.readObject();
                System.out.println(st);
            }

        } catch (EOFException e) {
            System.out.println("Da doc het file.");

        } catch (ClassNotFoundException e) {
            System.out.println("Loi: Khong tim thay lop du lieu.");
            e.printStackTrace();

        } catch (FileNotFoundException e) {
            System.out.println("Loi: Khong tim thay file.");
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("Loi vao/ra file.");
            e.printStackTrace();

        } catch (NumberFormatException e) {
            System.out.println("Loi: GPA phai la mot so.");
            e.printStackTrace();

        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                System.out.println("Loi khi dong file ghi.");
            }

            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                System.out.println("Loi khi dong file doc.");
            }

            sc.close();
            System.out.println("Program finished.");
        }
    }
}