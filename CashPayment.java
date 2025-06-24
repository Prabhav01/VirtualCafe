public class CashPayment implements PaymentStrategy{
    private double cashTendered;
    public CashPayment(double cashTendered){
        this.cashTendered = cashTendered;
    }
    @Override
    public boolean pay(double amount) {
        if (cashTendered >= amount) {
            double change = cashTendered - amount;
            System.out.println("Paid $" + String.format("%.2f", amount) + " with cash.");
            System.out.println("Cash tendered: $" + String.format("%.2f", cashTendered));
            System.out.println("Change: $" + String.format("%.2f", change));
            return true;
        } else {
            System.out.println("Insufficient cash provided. Required: $" +
                    String.format("%.2f", amount) + ", Provided: $" +
                    String.format("%.2f", cashTendered));
            return false;
        }
    }
}
