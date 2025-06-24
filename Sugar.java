public class Sugar extends DrinkDecorator {
    public Sugar(Drink drink) { 
        super(drink); 
    }

    @Override
    public String getDescription() { 
        return drink.getDescription() + ", Sugar"; 
    }

    @Override
    public double getCost() { 
        return drink.getCost() + 0.25; 
    }
}
