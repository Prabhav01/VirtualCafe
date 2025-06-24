import java.util.Scanner;

public class DrinkBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Drink drink = new BasicDrink();

        System.out.println("Welcome to the Drink Builder!");
        System.out.println("Choose your options below:");

        // Drink Options
        System.out.println("1. Espresso ($2.00)");
        System.out.println("2. Latte ($2.50)");
        System.out.println("3. Hot Chocolate ($3.00)");
        System.out.println("4. Boba Tea ($3.50)");
        System.out.print("Select your base drink (1-4): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            drink = new Espresso(drink);
        } else if (choice == 2) {
            drink = new Latte(drink);
        } else if (choice == 3) {
            drink = new HotChocolate(drink);
        } else if (choice == 4) {
            drink = new BobaTea(drink);
        }

        // Whipped Cream Option
        System.out.println("1. Add Whipped Cream ($0.50)");
        System.out.println("2. Skip Whipped Cream");
        System.out.print("Select whipped cream option (1/2): ");
        int whippedChoice = scanner.nextInt();
        if (whippedChoice == 1) {
            drink = new WhippedCream(drink);
        }

        // Sugar Option
        System.out.println("1. Add Sugar ($0.25)");
        System.out.println("2. Skip Sugar");
        System.out.print("Select sugar option (1/2): ");
        int sugarChoice = scanner.nextInt();
        if (sugarChoice == 1) {
            drink = new Sugar(drink);
        }

        // Milk Option
        System.out.println("1. Add Milk ($0.50)");
        System.out.println("2. Skip Milk");
        System.out.print("Select milk option (1/2): ");
        int milkChoice = scanner.nextInt();
        if (milkChoice == 1) {
            drink = new Milk(drink);
        }

        // Boba Pearls Option
        System.out.println("1. Add Boba Pearls ($0.75)");
        System.out.println("2. Skip Boba Pearls");
        System.out.print("Select boba pearls option (1/2): ");
        int bobaChoice = scanner.nextInt();
        if (bobaChoice == 1) {
            drink = new BobaBalls(drink);
        }

        // Marshmallows Option
        System.out.println("1. Add Marshmallows ($0.75)");
        System.out.println("2. Skip Marshmallows");
        System.out.print("Select marshmallows option (1/2): ");
        int marshChoice = scanner.nextInt();
        if (marshChoice == 1) {
            drink = new Marshmallows(drink);
        }

        // Final Drink
        System.out.println("\nYour Drink:");
        System.out.println("Description: " + drink.getDescription());
        System.out.println("Cost: $" + drink.getCost());

        scanner.close();
    }
}
