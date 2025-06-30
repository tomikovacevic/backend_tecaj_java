import java.util.Scanner;

//TODO try creating a scanner method and using it inside main and checkIfArmstrong
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char newGame;
        do {
            checkIfArmstrong(scan);
            System.out.println("Would you like to check a different number? (y/n)");
            newGame = scan.next().toLowerCase().charAt(0);
            // TODO code below doesn't work properly, handle proper input
            if(newGame != 'y' && newGame != 'n') {
                System.out.println("Incorrect input. Please input \"y\" or \"n\".");
            }
        } while (newGame != 'n');
        scan.close();
    }

    private static void checkIfArmstrong(Scanner scan) {
        //TODO handle proper input - use if condition
        System.out.println("Welcome!" + System.lineSeparator() + "Enter a number to check whether it's an Armstrong number or not:");
        int number = scan.nextInt();
        int numberForCalculation = number;
        int amountOfDigits = (int)(Math.log10(number)+1);
        int sum = 0;
        while (numberForCalculation > 0) {
            int digit = numberForCalculation % 10;
            sum += (int)(Math.pow(digit, amountOfDigits));
            numberForCalculation /= 10;
        }
        if(sum == number) {
            System.out.println(number + " is an Armstrong number");
        } else {
            System.out.println(number + " is not an Armstrong number");
        }
    }
}