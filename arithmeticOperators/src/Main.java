import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char odabir2;

        do {
            System.out.println("Unesite prvi broj:");
            int prviBroj = scan.nextInt();
            System.out.println("Unesite drugi broj:");
            int drugiBroj = scan.nextInt();
            System.out.println("Unesite matematičku operaciju (+. -, *, /)");
            char operater = scan.next().charAt(0);
            int rezultat = 0;

            switch (operater) {
                case '+':
                    rezultat = prviBroj + drugiBroj;
                    break;
                case '-':
                    rezultat = prviBroj - drugiBroj;
                    break;
                case '*':
                    rezultat = prviBroj * drugiBroj;
                    break;
                case '/':
                    rezultat = prviBroj / drugiBroj;
                    break;
                default:
                    System.out.println("Nepravilan unos");
                    break;
            }

            System.out.println("Rezultat: " + rezultat);
            System.out.println("Da li želite nastaviti (Y/n)");
            odabir2 = scan.next().charAt(0);

        } while (odabir2 != 'n');
    }
}