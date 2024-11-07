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
                model.addToLocations(new TaxLocation(labels[i], i, functionData[i], scanner));

            } else if (types[i].equals("Chance")) {
                model.addToLocations(new ChanceLocation(labels[i], i, scanner));

            } else if (types[i].equals("In Jail")) {
                model.addToLocations(new InJailLocation(labels[i], i, scanner));

            } else if (types[i].equals("GO Jail")) {
                model.addToLocations(new GoToJailLocation(labels[i], i, model.getLocations(), scanner));

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
        double[] random = new double[2];
        int jailRestirction = 0;
        printBoard();
        for (int i = 0; i < 7; i++) {
            for (Player player : players) {
                if (player.getProperty() < 0) {
                    continue;
                }
                jailRestirction = player.getjailRestirction();
                if (jailRestirction == 0) {
                    view.throwDiceMessage(player.getPlayerName());
                    scanner.nextLine();
                    random = throwDice();

                } else {

                    InJailLocation jail = null;
                    for (Location location : locations) {
                        if (player.getLocationIndex() == location.getLocationIndex()) {
                            jail = (InJailLocation) location;
                            break;
                        }
                    }

                    // String action = view.inJailThrow(player);

                    String action = jail != null ? jail.locationFunction(player) : "";

                    random = throwDice();

                    if (action.equals("P")) {
                        player.subProperty(150);

                    } else {
                        if (random[0] != random[1]) {
                            player.subJailRestriction();

                            // if(jailRestirction==1){
                            // System.out.println(player.getPlayerName()+", this is your last turn in
                            // Jail.\n\n");
                            // }else{
                            System.out.println(player.getPlayerName() + ", you still need to stay in Jail "
                                    + player.getjailRestirction() + " turn\n\n");

                            // }

                            if (player.getjailRestirction() == 0) {
                                /*
                                 * System.out.println(
                                 * "This is your last turns in jail, you must pay HKD 150 fine, then you can immediate moves forward."
                                 * );
                                 * System.out.println("Enter Y to pay: ");
                                 * 
                                 * action = scanner.nextLine().toUpperCase();
                                 * while (!action.equals("Y")) {
                                 * System.out.print("Invalid input. Please enter Y (Yes) to pay the fine: ");
                                 * action = scanner.nextLine().toUpperCase();
                                 * }
                                 * 
                                 * player.subProperty(150);
                                 */
                            } else {
                                continue;
                            }
                        } else {
                            player.zeroJailRestriction();
                        }
                    }

                }
                playerCurrentLocationIndex = player.getLocationIndex();
                if ((playerCurrentLocationIndex + (int) (random[0] + random[1])) >= 20) {
                    player.addProperty(1500);
                }
                playerNewLocationIndex = (playerCurrentLocationIndex + (int) (random[0] + random[1])) % 20;
                int searchIndex = 0;
                for (Location location : locations) {
                    if (location.getLocationIndex() == playerCurrentLocationIndex) {
                        location.removePlayer(player);
                    }

                    if (location.getLocationIndex() == playerNewLocationIndex) {
                        location.addPlayer(player);
                        player.setlocationIndex(playerNewLocationIndex);
                        location.locationFunction(player);
                        checkPlayerProperty(player);
                    }

                }
                // System.out.println(player);
                printBoard();
            }

            int negativePlayerCount = 0;
            for (Player player : players) {
                if (player.getProperty() < 0) {
                    negativePlayerCount++;
                }
            }
            Player winner = null;
            if ((players.size() - negativePlayerCount) == 1) {
                for (Player player : players) {
                    if (player.getProperty() > 0) {
                        winner = player;
                    }
                }
            }

            if (winner != null) {
                System.out.println("Congratulations, " + winner.getPlayerName() + ", you win!");
                break;
            }
        }
        System.out.println();
        view.printWinnerMessage(findWinner());

        

        
    }

    public ArrayList<Player> findWinner(){
        ArrayList<Player> winnerList = new ArrayList<>();
        Player maxPropertyPlayer = players.get(0);
        for (Player player : players) {
            if(maxPropertyPlayer.getProperty()<player.getProperty()){
                maxPropertyPlayer = player;
            }
        }
        //find multiple winner
        for (Player player : players) {
            if(maxPropertyPlayer.getProperty()==player.getProperty()){
                winnerList.add(player);
            }
        }

        return winnerList;

    }

    public void printBoard() {
        view.printBoard(locations, players);
    }

    public double[] throwDice() {
        // int[] randomNum = new int[2];
        /*
         * randomNum[0] = (int) (Math.random() * 6) + 1;
         * randomNum[1] = (int) (Math.random() * 6) + 1;
         */
        double[] randomNum = new double[2];

        randomNum[0] = 2;
        randomNum[1] = 2;
        //randomNum[0] = (int) (Math.random() * 6) + 1;
        //randomNum[1] = (int) (Math.random() * 6) + 1;
        System.out.println("First dice number is " + (int) randomNum[0]);
        System.out.println("Second dice number is " + (int) randomNum[1] + "\n");
        return randomNum;

    }

    public void checkPlayerProperty(Player p) {
        double property = p.getProperty();
        if (property < 0) {
            System.out.println(
                    "Unfortunately, " + p.getPlayerName() + ", your assets are negative. You will exit the game.");

            // model.removePlayer(p);
        }

    }

}