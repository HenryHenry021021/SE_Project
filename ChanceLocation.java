<<<<<<< HEAD
import java.util.Scanner;

public class ChanceLocation extends Location {
    public ChanceLocation(String locationName, int locationIndex, Scanner scanner) {
        super(locationName, locationIndex, scanner);
    }

    public void locationFunction(Player player) {
        String action;
        int chance = (int) (Math.random() * 2) + 1;
        System.out.println(player.getPlayerName()+", Please press Y (Yes) to decide if it's a reward or a penalty: ");
        action = scanner.nextLine().toUpperCase();
        while (!action.equals("Y")) {
            System.out.print("Invalid input. Please enter Y (Yes) to decide if it's a reward or a penalty: ");
            action = scanner.nextLine().toUpperCase();
        }

        if (chance == 1) {
            int award = ((int) (Math.random() * 20) + 1)*10;
            System.out.println("Congratulations! You have received an HKD "+award+" reward.");
            player.addProperty(award);
           
        }else{
            int penalty = ((int) (Math.random() * 30) + 1)*10;
            System.out.println("Unfortunately, you have been penalized with an HKD " + penalty + " deduction.");
            player.subProperty(penalty);
        }
        System.out.print("Press Y to continues the game: ");

        action = scanner.nextLine().toUpperCase();
        while (!action.equals("Y")) {
            System.out.print("Invalid input. Please enter Y to continues the game: ");
            action = scanner.nextLine().toUpperCase();
        }
    }
=======
import java.util.Scanner;

public class ChanceLocation extends Location {
    public ChanceLocation(String locationName, int locationIndex, Scanner scanner) {
        super(locationName, locationIndex, scanner);
    }

    public String locationFunction(Player player) {
        String action;
        int chance = (int) (Math.random() * 2) + 1;
        System.out.println(player.getPlayerName()+", Please press Y (Yes) to decide if it's a reward or a penalty: ");
        action = scanner.nextLine().toUpperCase();
        while (!action.equals("Y")) {
            System.out.print("Invalid input. Please enter Y (Yes) to decide if it's a reward or a penalty: ");
            action = scanner.nextLine().toUpperCase();
        }

        if (chance == 1) {
            int award = ((int) (Math.random() * 20) + 1)*10;
            System.out.println("Congratulations! You have received an HKD "+award+" reward.");
            player.addProperty(award);
           
        }else{
            int penalty = ((int) (Math.random() * 30) + 1)*10;
            System.out.println("Unfortunately, you have been penalized with an HKD " + penalty + " deduction.");
            player.subProperty(penalty);
        }
        System.out.print("Press enter to continues the game: ");

        action = scanner.nextLine().toUpperCase();
    
     
        return"";
    }


>>>>>>> c8ee6ec (jail successful)
}