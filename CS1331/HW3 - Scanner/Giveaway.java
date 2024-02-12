// I worked on the homework assignment alone, using only course materials
import java.util.Scanner;
public class Giveaway {
    public static void main(String[] args) {
        String[][] inventory = {{"x", "x", "StuffedPython", "x", "CSalt"}, {"hAIrspray", "x", "x", "x", "x"}, {"x", "x", "x", "JavaBeans", "x"}, {"x", "RustedMetal", "SwiftShoes", "x", "x"}, {"FuRniture", "x", "x", "GroovyGear", "RadiantRuby"}};
        Scanner user = new Scanner(System.in);
        System.out.println("Welcome to the 1331 Giveaway!\n");
        boolean empty = false;
        int count = 0;
        while (!empty) {
            for (int r = 0; r < inventory.length; r++) {
                for (int c = 0; c < inventory[r].length; c++) {
                    if (inventory[r][c].equals("x")) {
                        count += 1;
                        if (count == 25) {
                            empty = true;
                            System.out.println("\nSorry, we have no more items!");
                            return;
                        }
                    }
                }
            }
            count = 0;
            System.out.println("Would you like to take an item? [Y]es, [N]o, or [E]xit");
            String ans = user.next();
            if (ans.equals("E")) {
                System.out.println("Have a good day!");
                return;
            } else if (ans.equals("N")) {
                System.out.println("Next person in line!\n");
            } else if (ans.equals("Y")) {
                boolean success = false;
                while (!success) {
                    for (int r = 0; r < inventory.length; r++) {
                        System.out.print("\n");
                        System.out.print("|");
                        for (int c = 0; c < inventory[r].length; c++) {
                            System.out.print(inventory[r][c] + "|");
                        }
                    }
                    System.out.print("\n");
                    System.out.println("\nWhat item are you interested in taking?");
                    int row = Integer.parseInt(user.next());
                    int col = Integer.parseInt(user.next());
                    if (row > 4 || col > 4) {
                        System.out.println("\nLocation does not exist.");
                    } else if ((inventory[row][col]).equals("x")) {
                        System.out.println("\nThere is no item in this location.");
                    } else {
                        success = true;
                        System.out.println("\nYou successfully took the " + inventory[row][col] + "!");
                        inventory[row][col] = "x";
                        for (int r = 0; r < inventory.length; r++) {
                            System.out.print("\n");
                            System.out.print("|");
                            for (int c = 0; c < inventory[r].length; c++) {
                                System.out.print(inventory[r][c] + "|");
                            }
                        }
                        System.out.println("\n");
                    }
                }
            } else {
                System.out.println("\nPlease input 'Y', 'N', or 'E'.\n");
            }
        }
    }
}
