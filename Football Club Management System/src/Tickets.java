import java.io.Serializable;

public class Tickets implements PriceChangable{
    private double price;
    private String type;
    private String match;

    public Tickets(int price, String type, String match){
        this.price = price;
        this.type = type;
        this.match = match;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getMatch() {
        return match;
    }

    @Override
    public void changePrice(double newPrice) {
        this.price = newPrice;
        System.out.println("New price for seat " + type + ": " + price);
    }
}
