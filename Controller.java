import java.util.*;

public class Controller {

    private Model model;
    private View view;
    private int numOfPlayers;
    private int round;
    private Scanner scanner;
    private ArrayList<Location> locations;
    private ArrayList<Player> players;

    public Controller(Model model, View view, Scanner scanner) {
        this.model = model;
        this.view = view;
        numOfPlayers = 0;
        round = 0;
        this.scanner = scanner;
        // this.locations = model
    }

    public void addToLocation(String[] labels, int[] functionData, int[] rent, String[] types, Scanner scanner) {
        for (int i = 0; i < labels.length; i++) {
            if (types[i].equals("Rent")) {
                model.addToLocations(new RentLocation(labels[i], i, functionData[i], rent[i], scanner));

            } else if (types[i].equals("Special")) {
                model.addToLocations(new GoLocation(labels[i], i));

            } else if (types[i].equals("Tax")) {
                model.addToLocations(new TaxLocation(labels[i], i,functionData[i],scanner));

            } else if (types[i].equals("Chance")) {
                model.addToLocations(new ChanceLocation(labels[i], i, scanner));

            } else if (types[i].equals("In Jail")) {
                model.addToLocations(new InJailLocation(labels[i], i));

            } else if (types[i].equals("GO Jail")) {
                model.addToLocations(new GoToJailLocation(labels[i], i, model.getLocations()));

            } else if (types[i].equals("Free Parking")) {
                model.addToLocations(new ParkingLocation(labels[i], i));

            }
        }

        locations = model.getLocations();
    }

    public void addToPlayer(String[] names) {
        numOfPlayers = names.length;
        for (int i = 0; i < names.length; i++) {
            model.addToPlayers(new Player(names[i], 0));
        }
        players = model.getPlayers();
    }

    public void showLocations() {
        view.showLocations(model.getLocations());
    }

    public void showPlayers() {
        view.showPlayers(model.getPlayers());
    }

    public void gameSatrt() {
        ArrayList<Player> players = model.getPlayers();
        ArrayList<Location> locations = model.getLocations();
        int playerCurrentLocationIndex = 0;
        int playerNewLocationIndex = 0;
        int[] random = new int[2];

        printBoard();
        for (int i = 0; i < 100; i++) {
            for (Player player : players) {
                view.throwDiceMessage(player.getPlayerName());
                scanner.nextLine();
                playerCurrentLocationIndex = player.getLocationIndex();
                
                random = throwDice();
                playerNewLocationIndex = (playerCurrentLocationIndex + random[0]+random[1]) % 20;
                int searchIndex = 0;
                for (Location location : locations) {
                    if (location.getLocationIndex() == playerCurrentLocationIndex) {
                        location.removePlayer(player);
                    }

                    if (location.getLocationIndex() == playerNewLocationIndex) {
                        location.addPlayer(player);
                        player.setlocationIndex(playerNewLocationIndex);
                        location.locationFunction(player);
                    }

                }
                // System.out.println(player);
                printBoard();
            }
        }

    }

    public void printBoard() {
        view.printBoard(locations, players);
    }

    public int[] throwDice() {
        int[] randomNum = new int[2];
        /*randomNum[0] = (int) (Math.random() * 6) + 1;
        randomNum[1] = (int) (Math.random() * 6) + 1;*/

        randomNum[0] = 7;
        randomNum[1] = 8;

        System.out.println("First dice number is " + randomNum[0]);
        System.out.println("Second dice number is " + randomNum[1] + "\n");
        return randomNum;

    }

}