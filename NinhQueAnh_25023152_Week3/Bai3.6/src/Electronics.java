public class Electronics extends Product{
    protected double PhiBaoHanh;
    public Electronics(String id,String name,double price,double PhiBaoHanh){
        super(id,name,price);
        this.PhiBaoHanh=PhiBaoHanh;
    }
    @Override
    public double getFinalPrice(){return price*1.1+PhiBaoHanh;}
    public double getPhiBaoHanh(){return PhiBaoHanh;}
    public void setPhiBaoHanh(double PhiBaoHanh){this.PhiBaoHanh=PhiBaoHanh;}
}
