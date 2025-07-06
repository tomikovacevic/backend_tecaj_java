import java.util.InputMismatchException;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Unesite neki broj:");
                int input = sc.nextInt();
                sc.nextLine();

                if (input <= 0) {
                    throw new NotPositiveNumberException();
                }

                System.out.println("Faktorijel broja " + input + " je " + getFaktorijel(input));

            } catch (InputMismatchException e) {
                System.out.println("Unijeli ste neispravni tip.");
                sc.nextLine();
            } catch (NotPositiveNumberException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Želite li nastaviti? (y/n)");
            String nastavak = sc.nextLine();

            if (nastavak.equalsIgnoreCase("n")) {
                return;
            }
        }
    }

    private static int getFaktorijel(int number) {
        int rezultat = 1;
        for (int i = 1; i <= number; i++) {
            rezultat *= i;0
        }
        return rezultat;
    }
}
