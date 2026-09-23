import java.util.Scanner;
public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap Size: ");
        int size = sc.nextInt();
        sc.nextLine();
        IPayable[] payableList = new IPayable[size];
        double totalPay = 0;
        for (int i = 0; i < size; i++) {
            System.out.println("Nhap Du Lieu Doi Tuong: ");
            String line = sc.nextLine();
            String[] p = line.split(" ");
            if (p[0].equals("S")) {
                String id = p[1];
                String name = p[2];
                int hours = Integer.parseInt(p[3]);
                double rate = Double.parseDouble(p[4]);
                payableList[i] = new PartTimeStaff(id, name, hours, rate);
                totalPay+=payableList[i].getPaymentAmount();

            }
            else if (p[0].equals("I")) {
                String itemName = p[1];
                int quantity = Integer.parseInt(p[2]);
                double pricePerItem = Double.parseDouble(p[3]);
                payableList[i] = new Invoice(itemName, quantity, pricePerItem);
                totalPay+=payableList[i].getPaymentAmount();
            }
            else{
                System.out.println("Khong Co Doi Tuong!");
            }
        }
        System.out.println("------DangXuLy------");
        for (IPayable obj: payableList){
            System.out.println(obj);
        }
        System.out.println("TotalPayment: "+totalPay);
    }
}
