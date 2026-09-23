public class FishRobot extends Robot implements Swimmable{
    public FishRobot(int id, String moduleName){super(moduleName,id);}
    @Override
    public void performMainTask(){
        System.out.println("FishRobot dang trinh dien o duoi nuoc");
    }
    @Override
    public void swim(){
        System.out.println("FishRobot dang boi");
    }
}
