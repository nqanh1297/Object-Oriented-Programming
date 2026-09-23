class CentralHub {
    public void registerDevice(SmartLight light) {
        System.out.println("[HUB] Dang ket noi voi thiet bi: " + light.getName());
    }
}

public class SmartLight {
    private String id;
    private String name;
    private int brightness;

    public SmartLight(String id, String name, int brightness) {
        this.id = id;
        this.name = name;
        this.brightness = brightness;
    }

    public SmartLight(String id, String name) {
        this(id, name, 50);
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public void setBrightness(String preset) {
        if (preset.equals("MAX")) {
            setBrightness(100);
        } else if (preset.equals("MIN")) {
            setBrightness(10);
        } else if (preset.equals("ECO")) {
            setBrightness(30);
        }
    }

    public void connectToHub(CentralHub hub) {
        hub.registerDevice(this);
    }

    public String getName() {
        return name;
    }

    public void printInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Brightness: " + brightness);
        System.out.println("-------------------");
    }

    public static void main(String[] args) {
        CentralHub hub = new CentralHub();

        SmartLight l1 = new SmartLight("L01", "Den phong khach", 80);
        SmartLight l2 = new SmartLight("L02", "Den ngu");

        l1.setBrightness("ECO");
        l2.setBrightness("MAX");

        l1.connectToHub(hub);
        l2.connectToHub(hub);

        l1.printInfo();
        l2.printInfo();
    }
}