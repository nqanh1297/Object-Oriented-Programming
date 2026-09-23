public class PartTimeStaff extends Staff{
    protected int workingHours;
    protected double hourlyRate;
    public PartTimeStaff(String id,String name,int workingHours,double hourlyRate){
        super(id,name);
        this.workingHours=workingHours;
        this.hourlyRate=hourlyRate;
    }
    @Override
    public double getPaymentAmount(){return workingHours*hourlyRate;}
    public String toString(){
        return "PartTimeStaff "+name+" - Payment: "+getPaymentAmount();
    }
}
