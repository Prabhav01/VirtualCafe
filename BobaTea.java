public class BobaTea extends DrinkDecorator {
    public BobaTea(Drink drink) {
        super(drink);
    }

    @Override
    public String getDescription() {
        return drink.getDescription() + "Boba Tea";
    }

    @Override
    public double getCost() {
        return drink.getCost() + 3.50;
    }
}
