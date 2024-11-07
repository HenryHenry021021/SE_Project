import java.util.ArrayList;
import java.util.Scanner;

public class GoToJailLocation extends Location {
    ArrayList<Location> locations;
    public GoToJailLocation(String locationName, int locationIndex, ArrayList<Location> locations, Scanner scanner){
        super(locationName,locationIndex,scanner);
        this.locations = locations;
    }

    public  String locationFunction(Player player){
        System.out.println("Unfortunately, " + player.getPlayerName() + ", you need to go to jail.");
        
        for (int i = 0; i < locations.size(); i++) {
            Location location = locations.get(i);
            if (location instanceof InJailLocation) {
                player.setlocationIndex(location.getLocationIndex());
                removePlayer(player);
                location.addPlayer(player);
                player.setjailRestirction(3);
                //System.out.println("aaaaaaaaaaa");
            }
        }
        System.out.println("Press enter to continue the game.");
		scanner.nextLine().toUpperCase();

        return"";
    }

    
}