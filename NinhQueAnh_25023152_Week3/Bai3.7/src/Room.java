import java.util.Scanner;
public abstract class Room {
    protected int nights;
    public Room(int nights){
        this.nights=nights;
    }
    public int getNights(){return this.nights;}
    public void setNights(int nights){this.nights=nights;}
    public abstract double calculatePrice();
    public static void main(String []args) {
        System.out.println("Nhap So Luong Phong: ");
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        for (int i = 0; i < cnt; i++){
            System.out.println("Nhap Loai Phong");
            String TypeRoom = sc.next();
            if (TypeRoom.equals("S")){
                System.out.println("Nhap So Dem");
                int nights = sc.nextInt();
                Standard room = new Standard(nights);
                System.out.println("Gia Phong: "+room.calculatePrice());
            }
            else if (TypeRoom.equals("V")){
                System.out.println("Nhap So Dem");
                int nights = sc.nextInt();
                Vip room = new Vip(nights);
                System.out.println("Gia Phong: "+room.calculatePrice());
            }
            else {
                System.out.println("Khong Co Loai Phong Nay");
            }
        }

    }
}
