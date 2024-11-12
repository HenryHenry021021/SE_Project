import java.util.Scanner;

public class RentLocation extends Location {
	protected int price;
	protected int rent;



	public RentLocation(String locationName, int locationIndex, int price, int rent, Scanner scanner) {
		super(locationName, locationIndex, scanner);

		this.price = price;
		this.rent = rent;
	}

	public RentLocation(Player owner, String locationName, int locationIndex, int price, int rent, Scanner scanner) {
		super(locationName, locationIndex, scanner);
		this.price = price;
		this.rent = rent;
		this.owner = owner;

	}

	@Override
	public String toString() {

		String printMessage = locationName;
		/*
		 * if(owner!=null){
		 * printMessage+=", Owner:"+owner.getPlayerName();
		 * }
		 */
		return printMessage;
	}

	public String locationFunction(Player player) {
		String action;
		if (owner == null) {
			if (player.getProperty() > price) {
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
			} else {
				System.out.println("Althpugh " + locationName + " haven't owner, " + player.getPlayerName()
						+ ", you haven't sufficient money to buy it.");
				System.out.println("Press enter to continue the game.");
				action = scanner.nextLine().toUpperCase();

			}

		} else if (owner != player) {
			System.out.println(
					locationName + " belongs to " + owner.getPlayerName() + ", you need to pay rent of HKD " + rent);
			System.out.print("Press Y(Yes) to pay: ");

			action = scanner.nextLine().toUpperCase();
			while (!action.equals("Y")) {
				System.out.print("Invalid input. Please enter Y (Yes) to pay the rent: ");
				action = scanner.nextLine().toUpperCase();
			}

			if (action.equals("Y")) {
				player.subProperty(rent);
				owner.addProperty(rent);
			}

		}

		return "";

	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public int getRent() {
		return rent;
	}

	public Player getOwner() {
		return owner;
	}

}