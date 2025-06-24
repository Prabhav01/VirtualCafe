class ItalianBread extends SandwichDecorator {
    public ItalianBread(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + ", Italian Bread";
    }

    @Override
    public double getCost() {
        return sandwich.getCost() + 1.00;
    }
}