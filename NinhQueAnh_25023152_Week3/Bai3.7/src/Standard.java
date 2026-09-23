public class Standard extends Room{
    private int Cost=500;
    public Standard(int nights){super(nights);}
    @Override
    public double calculatePrice(){
        if (nights>3){return Cost*nights*0.95;}
        return Cost*nights;
    }
}
