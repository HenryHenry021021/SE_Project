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
}