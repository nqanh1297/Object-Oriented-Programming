import java.time.LocalDate;
public class Food extends Product{
    protected LocalDate expDate;
    public Food(String id,String name,double price,LocalDate expDate){
        super(id,name,price);
        this.expDate=expDate;
    }
    @Override
    public double getFinalPrice(){
        LocalDate today = LocalDate.now();
        if(expDate.isAfter(today) && expDate.isBefore(today.plusDays(7))){
            return price * 0.8;}
        return price;
    }
    public LocalDate getExpDate(){return expDate;}
}
