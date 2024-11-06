<<<<<<< HEAD
import java.util.ArrayList;

public class Model {
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Location> locations = new ArrayList<>();

        public void addToPlayers(Player player){
            players.add(player);
            locations.get(0).addPlayer(player);;
        }

        public void addToLocations(Location location){
            locations.add(location);
        }

        public ArrayList<Player> getPlayers(){
            return players;
        }

        public ArrayList<Location> getLocations(){
            return locations;
        }

=======
import java.util.ArrayList;

public class Model {
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Location> locations = new ArrayList<>();

        public void addToPlayers(Player player){
            players.add(player);
            locations.get(0).addPlayer(player);;
        }

        public void addToLocations(Location location){
            locations.add(location);
        }

        public void removePlayer(Player player){
            players.remove(player);
        }

        public ArrayList<Player> getPlayers(){
            return players;
        }

        public ArrayList<Location> getLocations(){
            return locations;
        }

>>>>>>> c8ee6ec (jail successful)
}