import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TODO enable user selecting type of number (from byte to long)
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int amountOfElements = getIntInput(sc, "Enter an amount of elements in an array that you want to generate:");
        if (amountOfElements == 0) {
            System.out.println("You have entered 0. Stopping application...");
            return;
        }
        System.out.println("Amount " + amountOfElements);

        int amountOfArrays = getIntInput(sc, "Optionally, if you want a multidimensional array, enter a number for how many (greater than 1):");

        int limit = getIntInput(sc, "Lastly, if you'd like to set a bound (exclusive) up to which the numbers will generate, enter a number higher than 0:");
        limit = (limit > 0) ? limit : Integer.MAX_VALUE;

        System.out.println("Limit " + limit);


        int[][] arr = (amountOfArrays > 0) ? new int[amountOfArrays][amountOfElements] : new int[1][amountOfElements];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("{");
            for (int j = 0; j < arr[i].length; j++) {
                if (j > 0) {
                    System.out.print(", ");
                }
                arr[i][j] = rand.nextInt(limit);
                System.out.print(arr[i][j]);
            }
            System.out.print("}");

            if (i < arr.length - 1) {
                System.out.println(",");
            }
        }
    }

    private static int getIntInput(Scanner scan, String prompt) {
        System.out.println(prompt);
        while (true) {
            String input = scan.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input can't be empty, please enter a number:");
                continue;
            } //replace try catch with regular if conditions
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException err) {
                System.out.println("You have entered an invalid input, please enter a number:");
            }
        }
    }
}