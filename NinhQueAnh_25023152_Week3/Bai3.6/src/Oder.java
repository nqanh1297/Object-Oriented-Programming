import java.time.LocalDate;

public class Oder {
    private Product[] products;
    private int cnt=0;
    public Oder(int size){
        products = new Product[size];
    }
    public void addProduct(Product other){products[cnt++]=other;}
    public double getTotal() {
        double sum = 0;
        for(int i = 0; i < cnt; i++){
            sum += products[i].getFinalPrice();
        }
        return sum;
    }
    public static void main(String [] args) {
        Electronics e1 = new Electronics("E01","DienTu1",1000,100);
        Food f1 = new Food("F01","DoAn1",50, LocalDate.of(2026,3,13));
        Electronics e2 = new Electronics("E02","DienTu2",500,30);
        Food f2 = new Food("F02","DoAn2",100,LocalDate.of(2026,3,25));
        Oder oder = new Oder(10);
        oder.addProduct(e1);
        oder.addProduct(e2);
        oder.addProduct(f1);
        oder.addProduct(f2);
        System.out.println(oder.getTotal());
    }
}
