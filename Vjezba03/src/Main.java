import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite nekakav tekst:");
        String input = sc.nextLine();

//        zadatak1(input);

        zadatak2(input);
    }

    private static void zadatak1(String tekst) {
        int counterLetters = 0;
        int counterNumbers = 0;
        int counterRest = 0;
        for (int i = 0; i < tekst.length(); i++) {
            char znak = tekst.charAt(i);
            if (Character.isDigit(znak)) {
                counterNumbers++;
            } else if (Character.isLetter(znak)) {
                counterLetters++;
            } else {
                counterRest++;
            }
        }
        System.out.println("Slova: " + counterLetters);
        System.out.println("Brojevi: " + counterNumbers);
        System.out.println("Ostali znakovi: " + counterRest);
    }

    private static void zadatak2(String tekst) {
        String[] rijeci = tekst.split(" ");
        for (int i = rijeci.length - 1; i >= 0; i--) {
            System.out.println(rijeci[i] + " ");
        }
    }
}


