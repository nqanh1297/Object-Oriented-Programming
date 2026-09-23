public class Tester extends Employee{
    protected int bugsFound;
    public Tester(String name,double baseSalary,int bugsFound){
        super(name,baseSalary);
        this.bugsFound=bugsFound;
    }
    @Override
    public double caculateBonus(){
        return 0.1*baseSalary+(bugsFound*50000);
    }
    public String toString(){
        return "Name: "+name+" - Bonus: "+caculateBonus();
    }
}
