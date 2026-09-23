public abstract class Product {
    protected String id;
    protected String name;
    protected double price;
    public Product(String id,String name,double price){
        this.id=id;
        this.name=name;
        this.price=price;
    }
    public abstract double getFinalPrice();
    public String getName(){return this.name;}
    public String getId(){return this.id;}
    public double getPrice(){return this.price;}
    public void setId(String id){this.id=id;}
    public void setName(String name){this.name=name;}
    public void setPrice(double price){this.price=price;}
}
