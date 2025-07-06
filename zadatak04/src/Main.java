import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ucilica ucilica = new Ucilica();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Unesite geometrijski oblik:");
            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "krug":
                    System.out.println("Unesite radijus:");
                    double radijus = scanner.nextDouble();
                    scanner.nextLine();
                    Krug krug = new Krug(radijus);
                    ucilica.add(krug);
                    break;

                case "trokut":
                    System.out.println("Unesite stranicu A:");
                    double trokutA = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Unesite stranicu B:");
                    double trokutB = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Unesite stranicu C:");
                    double trokutC = scanner.nextDouble();
                    scanner.nextLine();
                    Trokut trokut = new Trokut(trokutA, trokutB, trokutC);
                    ucilica.add(trokut);
                    break;

                case "pravokutnik":
                    System.out.println("Unesite stranicu A:");
                    double pravokutnikA = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Unesite stranicu B:");
                    double pravokutnikB = scanner.nextDouble();
                    scanner.nextLine();
                    Pravokutnik pravokutnik = new Pravokutnik(pravokutnikA, pravokutnikB);
                    ucilica.add(pravokutnik);
                    break;

                default:
                    System.out.println("Nemam taj lik. Možete li probati opet?");
                    continue;
            }

            ucilica.sort();

            System.out.println("Da li želite ispis geometrijskih likova? (y/n)");
            String ispis = scanner.nextLine();

            if (!ispis.equalsIgnoreCase("n")) {
                System.out.println(ucilica.get());
            }

            System.out.println("Da li želite nastaviti? (y/n)");
            String nastavak = scanner.nextLine();

            if (nastavak.equalsIgnoreCase("n")) {
                File outputFile = new File("my-file.txt");

                try (PrintWriter printWriter = new PrintWriter(outputFile)) {
                    printWriter.write(ucilica.get());
                } catch (Exception e) {
                    System.out.println("Desio se exception");
                }

                return;
            }
        }
    }
}