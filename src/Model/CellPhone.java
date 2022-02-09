package Model;

public class CellPhone extends Phone{
    private String region;
    private String status;

    public CellPhone(String name, double price, int amount, String vendor, String region, String status) {
        super(name, price, amount, vendor);
        this.region = region;
        this.status = status;
    }

    public CellPhone(int id, String name, double price, int amount, String vendor, String region, String status) {
        super(id, name, price, amount, vendor);
        this.region = region;
        this.status = status;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString()+ " - CellPhone{" +
                "region='" + region + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
