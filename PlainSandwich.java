// PlainSandwich.java
public class PlainSandwich extends Sandwich {
    @Override
    public String getDescription() {
        return "Plain Sandwich";
    }

    @Override
    public double getCost() {
        return 2.00; // base bread cost
    }
}
