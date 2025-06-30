import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int input;
            boolean firstTry = true;

            while (true) {
                if (firstTry) {
                    System.out.println("Unesite neki broj:");
                }

                try {
                    input = sc.nextInt();
                    sc.nextLine();

                    if (input <= 0) {
                        throw new NotPositiveNumberException();
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Unijeli ste neispravni tip, molimo unesite broj:");
                    sc.nextLine();
                    firstTry = false;
                } catch (NotPositiveNumberException e) {
                    System.out.println(e.getMessage());
                    firstTry = false;
                }
            }

            System.out.println("Faktorijel broja " + input + " je " + getFaktorijel(input));

            System.out.println("Želite li nastaviti? (y/n)");
            String nastavak = sc.nextLine();

            while (!nastavak.equalsIgnoreCase("y") && !nastavak.equalsIgnoreCase("n")) {
                System.out.println("Pogrešan unos, molim unesite \"y\" za nastavak ili \"n\" za zaustavljanje aplikacije:");
                nastavak = sc.nextLine();
            }

            if (nastavak.equalsIgnoreCase("n")) {
                return;
            }
        }
    }

    private static int getFaktorijel(int number) {
        int rezultat = 1;
        for (int i = 1; i <= number; i++) {
            rezultat *= i;
        }
        return rezultat;
    }
}
