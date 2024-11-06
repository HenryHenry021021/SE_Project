<<<<<<< HEAD
import java.util.ArrayList;

public class View {
    
    public void showLocations(ArrayList<Location> locations) {
        for (Location location : locations) {
            System.out.println(location);
        }
    }

    public void showPlayers(ArrayList<Player> players) {
        for (Player player : players) {
            System.out.println(player);
        }
    }

    public void printBoard(ArrayList<Location> locations, ArrayList<Player> players){
        showLocations(locations);
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        System.out.println("Player status:");
        showPlayers(players);
    }

    public void throwDiceMessage(String name){
        System.out.print(name + " please press any key to roll the dice:");
    }
=======
import java.util.ArrayList;
import java.util.Scanner;

public class View {
    Scanner scanner;
    public View(Scanner scanner){
        this.scanner = scanner;
    }
    public void showLocations(ArrayList<Location> locations) {
        for (Location location : locations) {
            System.out.println(location);
        }
    }

    public void showPlayers(ArrayList<Player> players) {
        for (Player player : players) {
            System.out.println(player);
        }
    }

    public void printBoard(ArrayList<Location> locations, ArrayList<Player> players){
        showLocations(locations);
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        System.out.println("Player status:");
        showPlayers(players);
    }

    public void throwDiceMessage(String name){
        System.out.print(name + " please press any key to roll the dice:");
    }

   /* public void throwDiceMessageInJail(String playerName, int jailRestirction) {
        System.out.println();
    }*/

    public  String inJailThrow(Player player){
        int jailRestirction =  player.getjailRestirction();
        String action = "";
        if(jailRestirction == 0){
            //player.setjailRestirction(3);
        }else if(jailRestirction == 3){
            System.out.println(player.getPlayerName()+", you are in Jail, you need to throwing doubles on any your next "+ jailRestirction+" turns.");
            System.out.println("Or paying a fine of HKD 150 brore your next tow turns");
            System.out.print("Press Y to throw the dice: ");

            action = scanner.nextLine().toUpperCase();

            while (!action.equals("Y")) {
                System.out.print("Invalid input. Please enter Y to throw the dice: ");
                action = scanner.nextLine().toUpperCase();
            }
        }else{
            System.out.println(player.getPlayerName()+", you are in Jail, you need to throwing doubles on any your next "+ jailRestirction+" turns.");
            System.out.println("Or paying a fine of HKD 150 then you can move forward");
            System.out.print("Press Y to throw dices or P to pay HKD 150: ");

            action = scanner.nextLine().toUpperCase();

            while (!action.equals("Y") &&!action.equals("P")) {
                System.out.print("Invalid input. Please enter Y or P: ");
                action = scanner.nextLine().toUpperCase();
            }
        }

        return action;
    }

    
>>>>>>> c8ee6ec (jail successful)
}