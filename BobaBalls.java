public class BobaBalls extends DrinkDecorator {
    public BobaBalls(Drink drink) {
        super(drink);
    }

    @Override
    public String getDescription() {
        return drink.getDescription() + ", Boba Balls";
    }

    @Override
    public double getCost() {
        return drink.getCost() + 0.75;
    }
}
