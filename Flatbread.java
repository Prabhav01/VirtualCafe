class Flatbread extends SandwichDecorator {
    public Flatbread(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + "Flatbread";
    }

    @Override
    public double getCost() {
        return sandwich.getCost() + 1.00;
    }
}