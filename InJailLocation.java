import java.util.Scanner;

public class InJailLocation extends Location {

    public InJailLocation(String locationName, int locationIndex, Scanner scanner) {
        super(locationName, locationIndex, scanner);
    }

    public String locationFunction(Player player) {
        int jailRestirction = player.getJailRestirction();
        String action = "";
        if(jailRestirction==0){

        }else if (jailRestirction == 1) {
            System.out.println(player.getPlayerName()+", this is your last turns in jail, you must pay HKD 150 fine, then you can immediate moves forward.");
            System.out.println("Enter Y to pay: ");

            action = scanner.nextLine().toUpperCase();
            while (!action.equals("Y")) {
                System.out.print("Invalid input. Please enter Y (Yes) to pay the fine: ");
                action = scanner.nextLine().toUpperCase();
            }

            player.subProperty(150);
        } else {
            System.out.println(
                    player.getPlayerName() + ", you are in Jail, you need to throwing doubles on any your next "
                            + jailRestirction + " turns.");
            System.out.println("Or paying a fine of HKD 150 then you can move forward");
            System.out.print("Press Y to throw dices or P to pay HKD 150: ");

            action = scanner.nextLine().toUpperCase();

            while (!action.equals("Y") && !action.equals("P")) {
                System.out.print("Invalid input. Please enter Y or P: ");
                action = scanner.nextLine().toUpperCase();
            }
        }

        return action;
    }
}