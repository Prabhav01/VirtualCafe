class BasicSandwich extends Sandwich {
    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public double getCost() {
        return 0.00; // Base sandwich starts with no cost
    }
}