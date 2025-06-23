import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write the amount of money you're returning to the customer:");
        double amount = scan.nextDouble();
        double[] change = {
                500,
                200,
                100,
                50,
                20,
                10,
                5,
                2,
                1,
                0.5,
                0.2,
                0.1,
                0.05,
                0.02,
                0.01
        };
        for (double i : change) {
            int counter = 0;
            while (amount >= i) {
                counter++;
                amount -= i;
            }
            System.out.println(counter + "*" + i);
        }
    }
}