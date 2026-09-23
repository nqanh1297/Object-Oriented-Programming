public class AmphibiousRobot extends Robot implements GPS,Swimmable,Flyable{
    public AmphibiousRobot(int id,String moduleName){super(moduleName,id);}
    public void performMainTask(){
        System.out.println("AmphibiousRobot dang trinh dien");
    }
    public void fly(){
        System.out.println("AmphibiousRobot dang bay");
    }
    public void getCoordinates(){
        System.out.println("AmphibiousRobot da ket noi GPS");
    }
    public void swim(){
        System.out.println("AmphibiousRobot dang boi");
    }
}
