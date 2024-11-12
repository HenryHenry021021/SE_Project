import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class Controller {

    private Model model;
    private View view;
    private int numOfPlayers;
    private int round;
    private Scanner scanner;
    private ArrayList<Location> locations;
    private ArrayList<Player> players;
    String[] names;

    public Controller(Model model, View view, Scanner scanner) {
        this.model = model;
        this.view = view;
        numOfPlayers = 0;
        round = 0;
        this.scanner = scanner;
        // this.locations = model
    }

    // public void addToLocation(String[] labels, int[] functionData, int[] rent, String[] types, int[] locationIndexs,
    //         Scanner scanner) {
    //     for (int i = 0; i < labels.length; i++) {
    //         if (types[i].equals("Rent")) {
    //             model.addToLocations(new RentLocation(labels[i], locationIndexs[i], functionData[i], rent[i], scanner));

    //         } else if (types[i].equals("Special")) {
    //             model.addToLocations(new GoLocation(labels[i], locationIndexs[i]));

    //         } else if (types[i].equals("Tax")) {
    //             model.addToLocations(new TaxLocation(labels[i], locationIndexs[i], functionData[i], scanner));

    //         } else if (types[i].equals("Chance")) {
    //             model.addToLocations(new ChanceLocation(labels[i], locationIndexs[i], scanner));

    //         } else if (types[i].equals("In Jail")) {
    //             model.addToLocations(new InJailLocation(labels[i], locationIndexs[i], scanner));

    //         } else if (types[i].equals("GO Jail")) {
    //             model.addToLocations(new GoToJailLocation(labels[i], locationIndexs[i], model.getLocations(), scanner));

    //         } else if (types[i].equals("Free Parking")) {
    //             model.addToLocations(new ParkingLocation(labels[i], locationIndexs[i]));

    //         }
    //     }

    //     locations = model.getLocations();
    // }
    public void start() {
        while (true) {
            System.out.println("Welcome to Monopoly Game!");
            System.out.println("Do you want to play game or design gameboard?");
            System.out.println("1. Play game");
            System.out.println("2. Design gameboard");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                addToLocation(scanner);
                showPlayers();
                gameSatrt();
                break;
            } else if (choice == 2) {
                viewGameBoard();
            }
        }
    }

    public void addToLocation(Scanner scanner) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get("data/Countinue.json"));
            String reader = String.join("\n", lines);

            JSONArray JSONGameBoard = new JSONArray(reader.toString());
            if (JSONGameBoard.length() != 0) {
                System.out.println("Continue of the gameboard(Enter 0) or create new gameboard(Enter anykey):");
                int choose = scanner.nextInt();
                if (choose == 0) {
                    chooseCountinueGameBoard();
                } else {
                    setPlayers();
                    chooseGameBoard();
                    addToPlayer(names);
                }
                model.setLocations(locations);
            }
        } catch (IOException e) {
        }
    }

    public void chooseCountinueGameBoard() {
        try {
            while (true) {
                List<String> lines = Files.readAllLines(Paths.get("data/Countinue.json"));
                String reader = String.join("\n", lines);
                JSONArray JSONGameBoard = new JSONArray(reader.toString());
                System.out.println("=============\nGameBoard Choose\n=============");
                for (int j = 0; j < JSONGameBoard.length(); j++) {
                    JSONObject gameboard = JSONGameBoard.getJSONObject(j);
                    System.out.println(j + 1 + ". " + gameboard.getString("date"));
                }

                System.out.println("=============");
                System.out.print("input menu: ");
                int choose = scanner.nextInt();
                ArrayList<Object> jsonData = getInProcess(JSONGameBoard.getJSONObject(choose - 1));

                System.out.print("Enter(0) or continue to view (another number):");
                int sure = scanner.nextInt();
                if (sure == 0) {
                    scanner.nextLine();
                    model.setLocations((ArrayList<Location>) jsonData.get(1));
                    model.setPlayers(((ArrayList<Player>) jsonData.get(0)));

                    players = model.getPlayers();
                    locations = model.getLocations();
                    break;
                }
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public void viewGameBoard() {
        try {
            while (true) {
                List<String> lines = Files.readAllLines(Paths.get("data/GameBoard.json"));
                String reader = String.join("\n", lines);

                JSONArray JSONGameBoard = new JSONArray(reader.toString());
                System.out.println("=============\nGameBoard\n=============");
                for (int j = 0; j < JSONGameBoard.length(); j++) {
                    JSONObject gameboard = JSONGameBoard.getJSONObject(j);
                    System.out.println(j + 1 + ". " + gameboard.getString("date"));
                }
                System.out.println("=============");
                System.out.print("input menu: ");
                int choose = scanner.nextInt();
                locations = getBoard(JSONGameBoard.getJSONObject(choose - 1).getJSONArray("data"));

                System.out.print("Modify the board(0), continue to view (another number):");

                int sure = scanner.nextInt();
                scanner.nextLine();

                if (sure == 0) {
                    System.out.print("Enter the index of the square you want to modify: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();

                    modifyGameBoard(JSONGameBoard, index, choose - 1);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void chooseGameBoard() {
        try {
            while (true) {
                List<String> lines = Files.readAllLines(Paths.get("data/GameBoard.json"));
                String reader = String.join("\n", lines);

                JSONArray JSONGameBoard = new JSONArray(reader.toString());
                System.out.println("=============\nGameBoard Choose\n=============");
                for (int j = 0; j < JSONGameBoard.length(); j++) {
                    JSONObject gameboard = JSONGameBoard.getJSONObject(j);
                    System.out.println(j + 1 + ". " + gameboard.getString("date"));
                }
                System.out.println("=============");
                System.out.print("input menu: ");
                int choose = scanner.nextInt();
                locations = getBoard(JSONGameBoard.getJSONObject(choose - 1).getJSONArray("data"));

                System.out.print("Enter(0), continue to view (another number):");

                int sure = scanner.nextInt();
                if (sure == 0) {
                    scanner.nextLine();
                    model.setLocations(locations);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Object> getInProcess(JSONObject gameboard) {
        System.out.println("=============\nGameBoard Info.\n=============");
        ArrayList<Object> arrays = new ArrayList<Object>(2);

        arrays.add(getUser(gameboard.getJSONArray("player")));
        arrays.add(getBoard(gameboard.getJSONArray("data")));

        return arrays;
    }

    public ArrayList<Location> getBoard(JSONArray JSONlocations) {
        System.out.println("=============\nGameBoard Info.\n=============");
        ArrayList<Location> specificlocations = new ArrayList<>();
        for (int i = 0; i < JSONlocations.length(); i++) {
            JSONObject location = JSONlocations.getJSONObject(i);
            if (location.getString("type").equals("Rent")) {
                
                specificlocations.add(
                        (!location.has("owner")
                                ? (new RentLocation(location.getString("labels"), i, location.getInt("price"),
                                        location.getInt("rent"), scanner))
                                : (new RentLocation(players.get(location.getInt("owner")), location.getString("labels"),
                                        i, location.getInt("price"),
                                        location.getInt("rent"), scanner))));

            } else if (location.getString("type").equals("Special")) {
                specificlocations.add(new GoLocation(location.getString("labels"), i));
            } else if (location.getString("type").equals("Tax")) {
                specificlocations
                        .add(new TaxLocation(location.getString("labels"), i, location.getInt("price"), scanner));
            } else if (location.getString("type").equals("Chance")) {
                specificlocations.add(new ChanceLocation(location.getString("labels"), i, scanner));
            } else if (location.getString("type").equals("In Jail")) {
                specificlocations.add(new InJailLocation(location.getString("labels"), i,scanner));
            } else if (location.getString("type").equals("GO Jail")) {
                specificlocations.add(new GoToJailLocation(location.getString("labels"), i, model.getLocations(),scanner));
            } else if (location.getString("type").equals("Free Parking")) {
                specificlocations.add(new ParkingLocation(location.getString("labels"), i));
            }
        }

        view.showLocations(specificlocations);
        return specificlocations;
    }

    public ArrayList<Player> getUser(JSONArray JSONUser) {
        System.out.println("=============\nUser Info.\n=============");
        ArrayList<Player> specificUsers = new ArrayList<>();
        for (int i = 0; i < JSONUser.length(); i++) {
            JSONObject user = JSONUser.getJSONObject(i);
            specificUsers.add(new Player(user.getString("name"), user.getDouble("property"),
                    user.getInt("locationIndex"), user.getInt("jailRestirction")));
        }

        view.showPlayers(specificUsers);
        players = specificUsers;
        return specificUsers;
    }

    public void modifyGameBoard(JSONArray JSONGameBoard, int indexToModify, int indexBoard) {

        try {

            while (true) {
                JSONObject gameboard = JSONGameBoard.getJSONObject(indexBoard);
                JSONArray locations = gameboard.getJSONArray("data");

                if (indexToModify < locations.length()) {
                    JSONObject person = locations.getJSONObject(indexToModify);
                    System.out.println("Original JSON: " + person.toString(4));

                    if (person.getString("type").equals("Rent")) {
                        System.out
                                .println("Moify the squares(Enter 0),Change other(Enter 1) or leave (Enter anykey):");
                    } else {
                        System.out.println("Change other(Enter 1) or leave (Enter anykey):");
                    }

                    int choose = scanner.nextInt();
                    scanner.nextLine();

                    if (choose == 0 && person.getString("type").equals("Rent")) {
                        locations.put(indexToModify, modify(person));
                    } else if (choose == 1) {
                        locations.put(indexToModify, changeType(locations, indexToModify));
                    } else {
                        break;
                    }
                }

                gameboard.put("data", locations);
                JSONGameBoard.put(indexBoard, gameboard);

                // Write modified JSON back to file
                Files.write(Paths.get("data/GameBoard.json"), JSONGameBoard.toString(4).getBytes());
                System.out.println("Modified JSON: " + locations.toString(4));

                System.out.print("Modify specify squares(Enter index) or leave(Enter anykey):");
                indexToModify = scanner.nextInt();
                if (indexToModify != 0) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public JSONObject modify(JSONObject person) {
        System.out.print("labels : " + person.getString("labels") + " new labels: ");
        String labels = scanner.nextLine();
        if (labels.isEmpty()) {
            person.put("labels", person.getString("labels"));
        } else {
            person.put("labels", labels);
        }

        System.out.print("price : " + person.getInt("price") + " new price: ");
        int price = scanner.nextInt();
        if (price == 0) {
            person.put("price", person.getInt("price"));
        } else {
            person.put("price", price);
        }

        System.out.print("rent : " + person.getInt("rent") + " new rent: ");
        int rent = scanner.nextInt();
        if (rent == 0) {
            person.put("rent", person.getInt("rent"));
        } else {
            person.put("rent", rent);
        }
        return person;
    }

    public JSONObject changeType(JSONArray JSONdata, int indexToModify) {

        ArrayList<Location> current = getBoard(JSONdata);

        ArrayList<Location> possible = new ArrayList<>(Arrays.asList(
                new RentLocation("Rent", 0, 0, 0, scanner),
                new GoLocation("Special", 0),
                new TaxLocation("Tax", 0, 0, scanner),
                new ChanceLocation("Chance", 0, scanner),
                new InJailLocation("In Jail", 0, scanner),
                new GoToJailLocation("GO Jail", 0, model.getLocations(), scanner),
                new ParkingLocation("Free Parking", 0)));

        for (Location location : current) {
            if (location instanceof InJailLocation) {
                possible.remove(4);
            }
        }

        JSONObject newLocation = new JSONObject();
        System.out.println("=============\nChange Type\n=============");
        for (int i = 0; i < possible.size(); i++) {
            System.out.println(i + 1 + ". " + possible.get(i).getLocationName());
        }
        System.out.println("=============");
        System.out.print("input menu: ");
        int choose = scanner.nextInt();
        scanner.nextLine();

        if (choose == 1) {
            RentLocation rent = new RentLocation("Rent", indexToModify, 0, 0, scanner);
            System.out.println("Please input labels: ");
            rent.setLocationName(scanner.nextLine());
            System.out.println("Please input price: ");
            rent.setPrice(scanner.nextInt());
            System.out.println("Please input rent: ");
            rent.setRent(scanner.nextInt());
            current.add(rent);
            newLocation.put("labels", rent.getLocationName());
            newLocation.put("price", rent.getPrice());
            newLocation.put("rent", rent.getRent());
        } else if (choose == 2) {
            current.add(new GoLocation("Special", indexToModify));
            newLocation.put("type", "Special");
            newLocation.put("labels", "GO");
        } else if (choose == 3) {
            current.add(new TaxLocation("Tax", indexToModify, 0, scanner));
            newLocation.put("type", "Tax");
            newLocation.put("labels", "INCOME TAX PAY 10%");
            newLocation.put("price", 10);
        } else if (choose == 4) {
            current.add(new ChanceLocation("Chance", indexToModify, scanner));
            newLocation.put("type", "Chance");
            newLocation.put("labels", "? CHANCE");
        } else if (choose == 5) {
            current.add(new InJailLocation("In Jail", indexToModify, scanner));
            newLocation.put("type", "In Jail");
            newLocation.put("labels", "IN JAIL JUST VISIT");
        } else if (choose == 6) {
            current.add(new GoToJailLocation("GO Jail", indexToModify, model.getLocations(), scanner));
            newLocation.put("type", "GO Jail");
            newLocation.put("labels", "GO TO JAIL");
        } else if (choose == 7) {
            current.add(new ParkingLocation("Free Parking", indexToModify));
            newLocation.put("type", "Free Parking");
            newLocation.put("labels", "FREE PARKING");
        } else {
        }
        return newLocation;
    }

    public void saveGame() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("data/Countinue.json"));
            String reader = String.join("\n", lines);
            JSONArray JSONGameBoard = new JSONArray(reader.toString());
            JSONObject gameboard = new JSONObject();

            gameboard.put("date", new Date().toString());
            gameboard.put("player", players);
            gameboard.put("data", locations);
            JSONGameBoard.put(gameboard);



            Files.write(Paths.get("data/Countinue.json"), JSONGameBoard.toString(4).getBytes());
        
            System.out.println("Game saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void view(){
        System.out.println("Player list");
        int count = 0;
        for(Player player:players){
            System.out.println(count+". "+player.getPlayerName());
            count ++;
        }
        System.out.print("View the status of any specific player (enter player index) and all players (no input required)");
        scanner.nextLine();
        String index = scanner.nextLine();


        if(!index.isEmpty()){
            System.out.println(players.get(Integer.valueOf(index)));

        }else{
            for(Player player:players){
                System.out.println(player);
            }
        }
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

    public void setPlayers() {
        System.out.print("Please input number of players (between 2 and 6): ");
        numOfPlayers = scanner.nextInt();

        while (numOfPlayers < 2 || numOfPlayers > 6) {
            System.out.print("Error: Number of players must be between 2 and 6. Try again: ");
            numOfPlayers = scanner.nextInt();

        }

        scanner.nextLine();
        names = new String[numOfPlayers];
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.print("Please input play" + (i + 1) + " name: ");
            names[i] = scanner.nextLine();
        }
    }

    public void gameSatrt() {
        ArrayList<Player> players = model.getPlayers();
        ArrayList<Location> locations = model.getLocations();
        int playerCurrentLocationIndex = 0;
        int playerNewLocationIndex = 0;
        double[] random = new double[2];
        int jailRestirction = 0;
        printBoard();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < players.size(); j++) {
                Player player = players.get(j);

                System.out.println("Game Menu:\n" +
                        "1. Gaming\n" +
                        "2. View player\n" +
                        "3. View game board\n" +
                        "4. View who is next one and show player info\n" +
                        "5. Save current game \n");
                System.out.print("input your choice:");
                int choose = scanner.nextInt();
                switch (choose) {
                    case 2:
                        view(); // View player

                        break;
                    case 3:
                        printBoard();
                        ; // View game board

                        break;
                    case 4:
                        // View who is next one and show player info
                        System.out.println(player);
                        break;
                    case 5:
                        saveGame(); // Save current game
                        break;

                    case 1:
                    default:

                        if (player.getProperty() < 0) {
                            continue;
                        }
                        jailRestirction = player.getJailRestirction();
                        if (jailRestirction == 0) {
                            view.throwDiceMessage(player.getPlayerName());
                            scanner.nextLine();
                            random = throwDice();

                        } else {

                            Location jail = null;
                            for (Location location : locations) {
                                if (player.getLocationIndex() == location.getLocationIndex()
                                        && location instanceof InJailLocation) {
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
                                            + player.getJailRestirction() + " turn\n\n");

                                    // }

                                    if (player.getJailRestirction() == 0) {
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
                        break;
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

    public ArrayList<Player> findWinner() {
        ArrayList<Player> winnerList = new ArrayList<>();
        Player maxPropertyPlayer = players.get(0);
        for (Player player : players) {
            if (maxPropertyPlayer.getProperty() < player.getProperty()) {
                maxPropertyPlayer = player;
            }
        }
        // find multiple winner
        for (Player player : players) {
            if (maxPropertyPlayer.getProperty() == player.getProperty()) {
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

        randomNum[0] = 7;
        randomNum[1] = 8;
        // randomNum[0] = (int) (Math.random() * 6) + 1;
        // randomNum[1] = (int) (Math.random() * 6) + 1;
        System.out.println("First dice number is " + (int) randomNum[0]);
        System.out.println("Second dice number is " + (int) randomNum[1]);
        System.out.println("Total step: " + ((int) (randomNum[0] + randomNum[1])) + "\n");
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