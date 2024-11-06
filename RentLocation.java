import java.util.Scanner;

public class RentLocation extends Location {
    protected int price;
    protected int rent;
    protected Player owner;
    public RentLocation(String locationName, int locationIndex, int price, int rent, Scanner scanner) {
        super(locationName,locationIndex,scanner);

        this.price = price;
		this.rent = rent;
        owner = null;

    }

    //@Override
    public String toString() {
        return locationName + " " + getPlayerList()  + rent+" *owner"+(owner!=null?owner.getPlayerName():"No person");
    }


    public void locationFunction(Player player) {
		String action;
		if (owner == null) {
			System.out.println(player.getPlayerName() + ", Do you want to buy this place?(" + locationName + ")");
			System.out.print("Y(Yes)/N(No): ");

			action = scanner.nextLine().toUpperCase();
			while (!action.equals("Y") && !action.equals("N")) {
				System.out.print("Invalid input. Please enter Y (Yes) or N (No): ");
				action = scanner.nextLine().toUpperCase();
			}

			if (action.equals("Y")) {
				owner = player;
				player.subProperty(price);
			}

		}else{
			System.out.println(locationName+" belongs to "+owner.getPlayerName()+", you need to pay rent of HKD "+rent);
			System.out.print("Press Y(Yes) to pay: ");


			action = scanner.nextLine().toUpperCase();
			while (!action.equals("Y")) {
				System.out.print("Invalid input. Please enter Y (Yes) to pay the rent: ");
				action = scanner.nextLine().toUpperCase();
			}

			if (action.equals("Y")) {
				player.subProperty(rent);
			}
			

		}

	}
}