import java.io.Serializable;

public class Players implements Serializable {
    private String name;
    private int age;
    private String nationality;
    private int shirtNumber;
    private double price;
    private int fitnessLevel;
    private int happinessLevel;

    // Constructor
    public Players(String name, int age, String nationality, int shirtNumber, double price, int fitnessLevel, int happinessLevel) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.shirtNumber = shirtNumber;
        this.price = price;
        this.fitnessLevel = fitnessLevel;
        this.happinessLevel = happinessLevel;
    }

    // Getters for each attribute
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public double getPrice() {
        return price;
    }

    public int getFitnessLevel() {
        return fitnessLevel;
    }

    public int getHappinessLevel() {
        return happinessLevel;
    }

    public String getPosition() {
        return "position";
    }
}
