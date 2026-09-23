import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        BufferedReader br = null;
        FileReader fr = null;
        FileWriter fw = null;
        PrintWriter pw=null;
        int soDong=0;

        System.out.println("Nhap duong dan tep nguon:");
        String sourcePath = sc.nextLine();

        System.out.println("Nhap duong dan tep dich:");
        String destPath = sc.nextLine();

        try {
            try {
                fr = new FileReader(sourcePath);
                br = new BufferedReader(fr);
            }
            catch (FileNotFoundException e) {
                System.out.println("Source file not found");
                return;
            }

            try {
                fw = new FileWriter(destPath);
                pw = new PrintWriter(fw);
            }
            catch (IOException e) {
                System.out.println("Cannot create destination file");
                return;
            }
            String line;
            while ((line = br.readLine())!=null) {
                pw.println(line);
                soDong++;
            }
            System.out.println("Copy successful");
            System.out.println("So dong da sao chep"+soDong);
        }
        catch (IOException e) {
            System.out.println("I/O error");
            e.printStackTrace();
        }
        finally {
            try {
                if (br != null)
                    br.close();
            }
            catch (IOException e) {
                System.out.println("Loi khi dong BufferedReader");
            }
            try {
                if (fr !=null)
                    fr.close();
            }
            catch (IOException e) {
                System.out.println("Loi khi dong FileReader");
            }
            if(pw!=null) pw.close();

            try {
                if (fw!=null)
                    fw.close();
            }
            catch (IOException e) {
                System.out.println("Loi khi dong FileWriter");
            }
            sc.close();
            System.out.println("Program finished");
        }
    }
}
