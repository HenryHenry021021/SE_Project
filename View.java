import java.util.ArrayList;
import java.util.Scanner;

public class View {
    Scanner scanner;

    public View(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showLocations(ArrayList<Location> locations) {
        int index = 1;
        for (Location location : locations) {
            System.out.println(index + ". " + location);
            index++;
        }
    }

    public void showPlayers(ArrayList<Player> players) {
        for (Player player : players) {
            System.out.println(player);
        }
    }

    public void printBoard(ArrayList<Location> locations, ArrayList<Player> players) {
        //showLocations(locations);
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        System.out.println("Player status:");
    
        System.out.println(
                "________________________________________________________________________________________________________________________________________________");
    
        System.out.printf("|   %-20s|   %-20s|   %-20s|   %-20s|   %-20s|   %-20s|\n",
                locations.get(0), locations.get(1), locations.get(2), locations.get(3), locations.get(4),
                locations.get(5));
        System.out.printf("|   %-20s|   %-20s|   %-20s|   %-20s|   %-20s|   %-20s|\n", 
                locations.get(0).getOwnerName(), locations.get(1).getOwnerName(), locations.get(2).getOwnerName(),
                locations.get(3).getOwnerName(), locations.get(4).getOwnerName(), locations.get(5).getOwnerName());
        System.out.printf("|   %-20s|   %-20s|   %-20s|   %-20s|   %-20s|   %-20s|\n", 
                locations.get(0).getPlayerList(), locations.get(1).getPlayerList(), locations.get(2).getPlayerList(),
                locations.get(3).getPlayerList(), locations.get(4).getPlayerList(), locations.get(5).getPlayerList());
    
        System.out.println(
                "|_______________________|_______________________|_______________________|_______________________|_______________________|_______________________|");
    
        System.out.printf("|   %-20s|%-95s|   %-20s|\n", locations.get(6), "", locations.get(7));
        System.out.printf("|   %-20s|%-95s|   %-20s|\n", 
                locations.get(6).getOwnerName(), "", locations.get(7).getOwnerName());
        System.out.printf("|   %-20s|%-95s|   %-20s|\n", 
                locations.get(6).getPlayerList(), "", locations.get(7).getPlayerList());
    
        System.out.printf("|_______________________|%-95s|_______________________|\n", "");
        System.out.printf("|   %-20s|%-95s|   %-20s|\n", locations.get(8), "", locations.get(9));
        System.out.printf("|   %-20s|%-95s|   %-20s|\n", 
                locations.get(8).getOwnerName(), "", locations.get(9).getOwnerName());
        System.out.printf("|   %-20s|%-95s|   %-20s|\n", 
                locations.get(8).getPlayerList(), "", locations.get(9).getPlayerList());
    
        System.out.printf("|_______________________|%-95s|_______________________|\n", "");
        System.out.printf("|   %-20s|%-95s|   %-20s|\n", locations.get(10), "", locations.get(11));
        System.out.printf("|   %-20s|%-95s|   %-20s|\n", 
                locations.get(10).getOwnerName(), "", locations.get(11).getOwnerName());
        System.out.printf("|   %-20s|%-95s|   %-20s|\n", 
                locations.get(10).getPlayerList(), "", locations.get(11).getPlayerList());
    
        System.out.printf("|_______________________|%-95s|_______________________|\n", "");
        System.out.printf("|   %-20s|%-95s|   %-20s|\n", locations.get(12), "", locations.get(13));
        System.out.printf("|   %-20s|%-95s|   %-20s|\n", 
                locations.get(12).getOwnerName(), "", locations.get(13).getOwnerName());
        System.out.printf("|   %-20s|%-95s|   %-20s|\n", 
                locations.get(12).getPlayerList(), "", locations.get(13).getPlayerList());
    
        System.out.println(
                "|_______________________|_______________________________________________________________________________________________|_______________________|");
    
        
        System.out.printf("|   %-20s|   %-20s|   %-20s|   %-20s|   %-20s|   %-20s|\n",
                locations.get(14), locations.get(15), locations.get(16), locations.get(17), locations.get(18),
                locations.get(19));
        System.out.printf("|   %-20s|   %-20s|   %-20s|   %-20s|   %-20s|   %-20s|\n", 
                locations.get(14).getOwnerName(), locations.get(15).getOwnerName(), locations.get(16).getOwnerName(),
                locations.get(17).getOwnerName(), locations.get(18).getOwnerName(), locations.get(19).getOwnerName());
        System.out.printf("|   %-20s|   %-20s|   %-20s|   %-20s|   %-20s|   %-20s|\n", 
                locations.get(14).getPlayerList(), locations.get(15).getPlayerList(), locations.get(16).getPlayerList(),
                locations.get(17).getPlayerList(), locations.get(18).getPlayerList(), locations.get(19).getPlayerList());
    
        System.out.println(
                "|_______________________|_______________________|_______________________|_______________________|_______________________|_______________________|");

                showPlayers(players);

    }
    
    

    public void throwDiceMessage(String name) {
        System.out.print(name + " please press any key to roll the dice:");
    }

    /*
     * public void throwDiceMessageInJail(String playerName, int jailRestirction) {
     * System.out.println();
     * }
     */

    public String inJailThrow(Player player) {
        int jailRestirction = player.getJailRestirction();
        String action = "";
        if (jailRestirction == 0) {
            // player.setjailRestirction(3);
        } else if (jailRestirction == 3) {
            System.out.println(
                    player.getPlayerName() + ", you are in Jail, you need to throwing doubles on any your next "
                            + jailRestirction + " turns.");
            System.out.println("Or paying a fine of HKD 150 brore your next tow turns");
            System.out.print("Press Y to throw the dice: ");

            action = scanner.nextLine().toUpperCase();

            while (!action.equals("Y")) {
                System.out.print("Invalid input. Please enter Y to throw the dice: ");
                action = scanner.nextLine().toUpperCase();
            }
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

    public void printWinnerMessage(ArrayList<Player> winners) {

        String winnerMessage = "Congratulations,";
        for (int i = 0; i < winners.size(); i++) {
            Player winner = winners.get(i);

            if (i == winners.size() - 1) {
                winnerMessage += winner.getPlayerName() + ", win the game";
            } else {
                winnerMessage += winner.getPlayerName() + ", ";
            }
        }

        System.out.println(winnerMessage);
    }

}