class MultigrainBread extends SandwichDecorator {
    public MultigrainBread(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + "Multigrain Bread";
    }

    @Override
    public double getCost() {
        return sandwich.getCost() + 1.00;
    }
}