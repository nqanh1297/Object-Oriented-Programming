public class Developer extends Employee{
    protected int overtimeHours;
    public Developer(String name,double baseSalary,int overtimeHours){
        super(name,baseSalary);
        this.overtimeHours=overtimeHours;
    }
    @Override
    public double caculateBonus(){
        return 0.1*baseSalary+(overtimeHours*200000);
    }
    public String toString(){
        return "Name: "+name+" - Bonus: "+caculateBonus();
    }
}
