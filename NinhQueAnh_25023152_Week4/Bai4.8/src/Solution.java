import java.util.*;

abstract class Device {
    protected String id;
    protected String name;
    protected boolean on;

    public Device(String id, String name) {
        this.id = id;
        this.name = name;
        this.on = false;
    }

    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on = false;
    }

    public String getStatus() {
        return on ? "On" : "Off";
    }

    public abstract String getType();

    @Override
    public String toString() {
        return getType() + " " + id + " " + name + " - " + getStatus();
    }
}

interface WifiSupport {
    void setupWifi(String wifiName);
}

interface BrightnessControl {
    void increaseBrightness();
    void decreaseBrightness();
}

interface TemperatureControl {
    void increaseTemperature();
    void decreaseTemperature();
}

interface VolumeControl {
    void increaseVolume();
    void decreaseVolume();
}

class SmartLight extends Device implements BrightnessControl {
    private int brightness;

    public SmartLight(String id, String name) {
        super(id, name);
        brightness = 50;
    }

    @Override
    public void increaseBrightness() {
        if (brightness < 100) brightness += 10;
    }

    @Override
    public void decreaseBrightness() {
        if (brightness > 0) brightness -= 10;
    }

    @Override
    public String getType() {
        return "Light";
    }

    @Override
    public String toString() {
        return super.toString() + " - Brightness: " + brightness;
    }
}

class AirConditioner extends Device implements TemperatureControl {
    private int temperature;

    public AirConditioner(String id, String name) {
        super(id, name);
        temperature = 24;
    }

    @Override
    public void increaseTemperature() {
        temperature++;
    }

    @Override
    public void decreaseTemperature() {
        temperature--;
    }

    @Override
    public String getType() {
        return "AirConditioner";
    }

    @Override
    public String toString() {
        return super.toString() + " - Temperature: " + temperature;
    }
}

class SmartSpeaker extends Device implements VolumeControl, WifiSupport {
    private int volume;
    private String wifiName;

    public SmartSpeaker(String id, String name) {
        super(id, name);
        volume = 50;
        wifiName = "Not connected";
    }

    @Override
    public void increaseVolume() {
        if (volume < 100) volume += 10;
    }

    @Override
    public void decreaseVolume() {
        if (volume > 0) volume -= 10;
    }

    @Override
    public void setupWifi(String wifiName) {
        this.wifiName = wifiName;
    }

    @Override
    public String getType() {
        return "Speaker";
    }

    @Override
    public String toString() {
        return super.toString() + " - Volume: " + volume + " - Wifi: " + wifiName;
    }
}

class Curtain extends Device {
    public Curtain(String id, String name) {
        super(id, name);
    }

    public void open() {
        turnOn();
    }

    public void close() {
        turnOff();
    }

    @Override
    public String getType() {
        return "Curtain";
    }

    @Override
    public String getStatus() {
        return on ? "Open" : "Closed";
    }
}

class Hub {
    private List<Device> devices;

    public Hub() {
        devices = new ArrayList<>();
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void turnOffAll() {
        for (Device d : devices) {
            d.turnOff();
        }
    }

    public void setupWifi(String wifiName) {
        for (Device d : devices) {
            if (d instanceof WifiSupport) {
                ((WifiSupport) d).setupWifi(wifiName);
            }
        }
    }

    public void printDevices() {
        for (Device d : devices) {
            System.out.println(d);
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Hub hub = new Hub();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();

            switch (type) {
                case "L":
                    hub.addDevice(new SmartLight(id, name));
                    break;
                case "AC":
                    hub.addDevice(new AirConditioner(id, name));
                    break;
                case "S":
                    hub.addDevice(new SmartSpeaker(id, name));
                    break;
                case "C":
                    hub.addDevice(new Curtain(id, name));
                    break;
            }
        }

        for (Device d : hub.getDevices()) {
            d.turnOn();

            if (d instanceof BrightnessControl) {
                ((BrightnessControl) d).increaseBrightness();
            }

            if (d instanceof TemperatureControl) {
                ((TemperatureControl) d).decreaseTemperature();
            }

            if (d instanceof VolumeControl) {
                ((VolumeControl) d).increaseVolume();
            }
        }

        hub.setupWifi("HomeWifi");

        System.out.println("Before Turn Off All:");
        hub.printDevices();

        hub.turnOffAll();

        System.out.println("After Turn Off All:");
        hub.printDevices();

        sc.close();
    }
}