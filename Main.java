import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    int numOfPlayers = 0;

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
        System.out.println(1567 % 10);
        controller.start();

        // String[] labels = {"FREE PARKING", "Shatin HKD 700", "? CHANCE", "Tuen Mun
        // HKD 400", "Tai Po HKD 500", "GO TO JAIL",
        // "Tsing Yi HKD 400", "Sai Kung HKD 400",
        // "? CHANCE", "Yuen Long HKD 400",
        // "Mong Kok HKD 500","? CHANCE",
        // "Shek O HKD 400","Tai O HKD 600",
        // "IN JAIL JUST VISIT","Stanley HKD 600","INCOME TAX PAY 10%","Wan Chai HKD
        // 700","CENTRAL HKD 800","GO"};

        // int[] functionData = {
        // 0, 700, 0, 400, 500, 0,
        // 400, 400,
        // 0, 400,
        // 0, 600,
        // 500, 0,
        // 400, 600,
        // 0, 600, 10,700,800,0
        // };

        // int[] rent = {
        // 0, 75, 0, 20, 25,
        // 15, 10,
        // 0, 25,
        // 40, 0,
        // 10, 25,
        // 0, 60, 10, 65, 0, 90, 0
        // };

        // String[] types = {
        // "Free Parking", "Rent", "Chance", "Rent", "Rent", "GO Jail",
        // "Rent", "Rent",
        // "Chance", "Rent",
        // "Rent", "Chance",
        // "Rent","Rent",
        // "In Jail", "Rent", "Tax", "Rent", "Rent", "Special"
        // };

        // int[] locationIndexs = {10, 11, 12, 13, 14, 15,
        // 9,16,
        // 8,17,
        // 7,18,
        // 6,19,
        // 5,4,3,2,1,0};

        // set user
        // mainCall.setPlayers();

        // controller.addToLocation(labels, functionData,
        // rent,types,locationIndexs,mainCall.scanner);
        // controller.addToPlayer(mainCall.names);

        // controller.showPlayers();

        // controller.gameSatrt();


    }

}