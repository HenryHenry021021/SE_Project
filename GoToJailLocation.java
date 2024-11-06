import java.util.ArrayList;

public class GoToJailLocation extends Location {
    ArrayList<Location> locations;
    public GoToJailLocation(String locationName, int locationIndex, ArrayList<Location> locations){
        super(locationName,locationIndex,null);
        this.locations = locations;
    }

    public  void locationFunction(Player player){
        System.out.println("Unfortunately, " + player.getPlayerName() + ", you need to go to jail.");
        
        for (int i = 0; i < locations.size(); i++) {
            Location location = locations.get(i);
            if (location instanceof InJailLocation) {
                player.setlocationIndex(i);
                removePlayer(player);
                location.addPlayer(player);
                System.out.println("aaaaaaaaaaa");
            }
        }
        
    }

    
}