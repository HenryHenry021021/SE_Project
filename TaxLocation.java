import java.util.Scanner;

public class TaxLocation extends Location {
    private double tax;
    private double taxCost;

    public TaxLocation(String locationName, int locationIndex, double tax, Scanner scanner) {
        super(locationName, locationIndex, scanner);
        this.tax = tax/100;
    }

    public void locationFunction(Player player) {
        double calCost = player.getProperty() * tax;
        double lowerThan10 = calCost % 10;
        double addcost = 0;
        String action;
        if (lowerThan10 >= 5) {
            taxCost = calCost - lowerThan10 + 10;
        }else{
            taxCost = calCost- lowerThan10;
        }

        System.out.println(player.getPlayerName() + ", you need to pat tax HKD" + taxCost);
        System.out.print("Press Y(Yes) to pay: ");
        action = scanner.nextLine().toUpperCase();
        while (!action.equals("Y")) {
            System.out.print("Invalid input. Please enter Y (Yes) to pay the tax: ");
            action = scanner.nextLine().toUpperCase();
        }

        player.subProperty(taxCost);

    }
}