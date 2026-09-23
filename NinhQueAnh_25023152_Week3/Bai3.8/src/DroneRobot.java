public class DroneRobot extends Robot implements Flyable,GPS,ElectronicDevice{
    public DroneRobot(int id, String modelName) {super(modelName,id);}
    @Override
    public void performMainTask(){System.out.println("Drone dang trinh dien");}
    @Override
    public void fly() {System.out.println("Drone dang bat dau bay len");}
    @Override
    public void getCoordinates() {System.out.println("GPS da duoc ket noi");}
    @Override
    public void turnOn(){System.out.println("Da Bat");}
}
