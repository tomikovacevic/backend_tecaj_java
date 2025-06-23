import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ucilica ucilica = new Ucilica();
        Scanner scanner = new Scanner(System.in);
        String nastavak = "";
        do {
            System.out.println("Unesi geometrijski oblik");
            String input = scanner.nextLine();

            switch (input) {
                case "Krug":
                    System.out.println("Unesite radijus:");
                    double radijus = scanner.nextDouble();
                    Krug krug = new Krug(radijus);
                    ucilica.add(krug);
                    break;

                case "Trokut":
                    System.out.println("Unesite radijus:");
                    double radijus = scanner.nextDouble();
                    Krug krug = new Krug(radijus);
                    ucilica.add(krug);
                    break;

                case "Pravokutnik":
                    break;

                default:
                    System.out.println("Nemam taj lik.");
                    continue;

                    System.out.println("Da li želite nastaviti? (Y/n)");
                    nastavak = scanner.nextLine();
            }
        } while (!nastavak.equalsIgnoreCase("n"));
        // Trokut, Pravokutnik, Krug
    }
}