public class SpecialPlayer extends Players {
    private boolean inForm;

    public SpecialPlayer(String name, int age, String nationality, int shirtNumber, double price, int fitnessLevel, int happinessLevel) {
        super(name, age, nationality, shirtNumber, price, fitnessLevel, happinessLevel);
        this.inForm = false; // Default value
    }

    public boolean isInForm() {
        return inForm;
    }

    public void trainPlayer() {
        this.inForm = true;
    }
}