public class Marshmallows extends DrinkDecorator {
    public Marshmallows(Drink drink) {
        super(drink);
    }

    @Override
    public String getDescription() {
        return drink.getDescription() + ", Marshmallows";
    }

    @Override
    public double getCost() {
        return drink.getCost() + 0.75;
    }
}
