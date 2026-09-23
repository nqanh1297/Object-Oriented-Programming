public abstract class Robot {
    private int id;
    private String moduleName;
    private int batteryLevel;
    public Robot(String moduleName,int id){
        this.id=id;
        this.moduleName=moduleName;
    }
    public void chargeBattery(){this.batteryLevel=100;}
    public final void showIdenity(){
        System.out.println(id+"-"+moduleName);
    }
    public abstract void performMainTask();

    public String getModuleName() {
        return moduleName;
    }
    public static void main(String []args) {
        Robot[] robot = new Robot[3];
        robot[0] = new DroneRobot(01,"DR-01");//upCasting
        robot[1] = new FishRobot(02,"FR-02");//upCasting
        robot[2] = new AmphibiousRobot(03,"AR-03");//upCasting
        for (Robot r: robot){
            r.showIdenity();
            r.performMainTask();
        }
        System.out.println("------DroneRobot------");
        Robot r = robot[0];
        //r.fly() => lỗi do tham chiếu robot không có method fly()
        DroneRobot dr = (DroneRobot) r; //dowmCasting
        dr.fly();
        System.out.println("------CheckClass/Interface------");
        for (Robot rs:robot){
            System.out.println("----"+rs.getModuleName()+"----");
            if (rs instanceof Flyable){((Flyable) rs).fly();}// Kiểm tra xem có dùng giao diện Flyable không
            if (rs instanceof GPS){((GPS) rs).getCoordinates();}//Kiểm tra xem dùng giao diện GPS không
            if (rs instanceof Swimmable){((Swimmable) rs).swim();}//Kiểm tra xem dùng giao diện Swimmable không
        }
    }
}
