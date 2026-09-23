public class Invoice implements IPayable{
    private String itemName;
    private int quantity;
    private double pricePerItem;
    public Invoice(String itemName, int quantity,double pricePerItem){
        this.itemName=itemName;
        this.pricePerItem=pricePerItem;
        this.quantity=quantity;
    }
    @Override
    public double getPaymentAmount(){return pricePerItem*quantity;}
    public String toString(){
        return "Invoice "+itemName+" - Payment: "+getPaymentAmount();
    }
}
