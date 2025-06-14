import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = scan.nextInt();
        int sum = 0;
        for (int i = 0; i < number; i++) {
            sum += i;
        }

        System.out.println(sum);
    }
}