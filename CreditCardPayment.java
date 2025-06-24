public class CreditCardPayment implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreditCardPayment(String name, String cardNumber, String cvv, String dateOfExpiry) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paying $" + String.format("%.2f", amount) + " with credit card: " +
                cardNumber.substring(0, 4) + "-XXXX-XXXX-" +
                cardNumber.substring(cardNumber.length() - 4));
        return true;
    }
}
