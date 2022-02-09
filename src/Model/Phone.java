package Model;

public class Phone {
    private int id;
    private String name;
    private double price;
    private int amount;
    private String vendor;

    public Phone(String name, double price, int amount, String vendor) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.vendor = vendor;
    }

    public Phone(int id, String name, double price, int amount, String vendor) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.vendor = vendor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", vendor='" + vendor + '\'' +
                '}';
    }
}
