package Model;

import java.util.Date;

public class AuthPhone extends Phone{
    private int timeMaintain;
    private String region;

    public AuthPhone(String name, double price, int amount, String vendor, int timeMaintain, String region) {
        super(name, price, amount, vendor);
        this.timeMaintain = timeMaintain;
        this.region = region;
    }

    public AuthPhone(int id, String name, double price, int amount, String vendor, int timeMaintain, String region) {
        super(id, name, price, amount, vendor);
        this.timeMaintain = timeMaintain;
        this.region = region;
    }

    public int getTimeMaintain() {
        return timeMaintain;
    }

    public void setTimeMaintain(int timeMaintain) {
        this.timeMaintain = timeMaintain;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return super.toString() + " - AuthPhone{" +
                "timeMaintain=" + timeMaintain +
                ", region='" + region + '\'' +
                '}';
    }
}
