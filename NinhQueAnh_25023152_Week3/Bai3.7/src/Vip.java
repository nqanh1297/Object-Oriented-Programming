public class Vip extends Room{
    private int Cost=2000;
    public Vip(int nights){
        super(nights);
    }
    @Override
    public double calculatePrice(){
        return Cost*nights;
    }
}
