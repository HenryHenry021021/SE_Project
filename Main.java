<<<<<<< HEAD
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    int numOfPlayers = 0;
    String[] names;
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Main mainCall = new Main();

        Controller controller = new Controller(model, view, mainCall.scanner);

    
        // clear command line
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(1567%10);
        String[] labels = {
                "GO", "CENTRAL HKD 800", "Wan Chai HKD 700", "INCOME TAX PAY 10%", "Stanley HKD 600",
                "IN JAIL JUST VISIT", "Shek O HKD 400", "Mong Kok HKD 500","? CHANCE", "Tsing Yi HKD 400", "FREE PARKING",
                "Shatin HKD 700", "? CHANCE", "Tuen Mun HKD 400", "Tai Po HKD 500", "GO TO JAIL",
                 "Sai Kung HKD 400",  "Yuen Long HKD 400","? CHANCE", "Tai O HKD 600"
        };

        int[] functionData = {
            0, 800, 700, 10, 600,
            0, 400, 500, 0, 400,
            0, 700, 0, 400, 500,
            0, 400, 400, 0, 600
        };

        int[] rent = {
            0, 90, 65, 0, 60,
            0, 10, 40, 0, 15,
            0, 75, 0, 20, 25,
            0, 10, 25, 0, 25
        };
        
        String[] types = {
            "Special", "Rent", "Rent", "Tax", "Rent",
            "In Jail", "Rent", "Rent", "Chance", "Rent",
            "Free Parking", "Rent", "Chance", "Rent", "Rent",
            "GO Jail", "Rent", "Rent", "Chance", "Rent"
        };
//set user
        mainCall.setPlayers();


        controller.addToLocation(labels, functionData, rent,types,mainCall.scanner);
        controller.addToPlayer(mainCall.names);

  
        controller.showPlayers();

        controller.gameSatrt();
    }

    public void setPlayers() {
        System.out.print("Please input number of players: ");
        numOfPlayers = scanner.nextInt();
        scanner.nextLine();
        names = new String[numOfPlayers];
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.print("Please input play" + (i + 1) + " name: ");
            names[i] = scanner.nextLine();
        }
    }

    
=======
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    int numOfPlayers = 0;
    String[] names;
    public static void main(String[] args) {
        Model model = new Model();
        Main mainCall = new Main();
        View view = new View(mainCall.scanner);

        Controller controller = new Controller(model, view, mainCall.scanner);

    
        // clear command line
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(1567%10);
        String[] labels = {
                "GO", "CENTRAL HKD 800", "Wan Chai HKD 700", "INCOME TAX PAY 10%", "Stanley HKD 600",
                "IN JAIL JUST VISIT", "Shek O HKD 400", "Mong Kok HKD 500","? CHANCE", "Tsing Yi HKD 400", "FREE PARKING",
                "Shatin HKD 700", "? CHANCE", "Tuen Mun HKD 400", "Tai Po HKD 500", "GO TO JAIL",
                 "Sai Kung HKD 400",  "Yuen Long HKD 400","? CHANCE", "Tai O HKD 600"
        };

        int[] functionData = {
            0, 800, 700, 10, 600,
            0, 400, 500, 0, 400,
            0, 700, 0, 400, 500,
            0, 400, 400, 0, 600
        };

        int[] rent = {
            0, 90, 65, 0, 60,
            0, 10, 40, 0, 15,
            0, 75, 0, 20, 25,
            0, 10, 25, 0, 25
        };
        
        String[] types = {
            "Special", "Rent", "Rent", "Tax", "Rent",
            "In Jail", "Rent", "Rent", "Chance", "Rent",
            "Free Parking", "Rent", "Chance", "Rent", "Rent",
            "GO Jail", "Rent", "Rent", "Chance", "Rent"
        };
//set user
        mainCall.setPlayers();


        controller.addToLocation(labels, functionData, rent,types,mainCall.scanner);
        controller.addToPlayer(mainCall.names);

  
        controller.showPlayers();

        controller.gameSatrt();
    }

    public void setPlayers() {
        System.out.print("Please input number of players: ");
        numOfPlayers = scanner.nextInt();
        scanner.nextLine();
        names = new String[numOfPlayers];
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.print("Please input play" + (i + 1) + " name: ");
            names[i] = scanner.nextLine();
        }
    }

    
>>>>>>> c8ee6ec (jail successful)
}