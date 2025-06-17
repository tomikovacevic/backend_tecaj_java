import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite OIB:");
        String oib = sc.next();

        if (oib.length() != 11) {
            System.out.println("OIB mora sadržati 11 znamenki.");
            return;
        }
        checkOIB(oib);
    }

    private static void checkOIB(String oib) {
        int controlNumber = 0;
        for (int i = 0; i < oib.length() - 1; i++) {
            int digit = Character.getNumericValue(oib.charAt(i));
            if (i == 0) {
                controlNumber = digit + 10;
            } else {
                controlNumber += digit;
            }

            if (controlNumber % 10 == 0) {
                controlNumber = 10;
            } else {
                controlNumber %= 10;
            }

            controlNumber *= 2;
            controlNumber %= 11;
        }

        if (controlNumber == 1) {
            controlNumber = 0;
        } else {
            controlNumber = 11 - controlNumber;
        }

        if (controlNumber == Character.getNumericValue(oib.charAt(10))) {
            System.out.println("Uneseni OIB je valjan.");
        } else {
            System.out.println("Uneseni OIB nije valjan.");
        }
    }
}