import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TODO separate menu display into a method
        final String NOVI_RED = System.lineSeparator();
        StringBuilder sbMeni = new StringBuilder();
        Osoblje osoblje = new Osoblje();
        Scanner sc = new Scanner(System.in);
        osoblje.ucitajOsobeIzDatoteke();
        int izbor;

        sbMeni.append("Unesite brojku ispred željene opcije:")
                .append(NOVI_RED)
                .append("1. Unos profesora")
                .append(NOVI_RED)
                .append("2. Unos studenta")
                .append(NOVI_RED)
                .append("3. Filtriranje")
                .append(NOVI_RED)
                .append("4. Ispis")
                .append(NOVI_RED)
                .append("5. Izlaz");

        do {
            System.out.println(sbMeni);
            izbor = sc.nextInt();
            switch (izbor) {
                case 1:
                    try {
                        Profesor p = unesiProfesora(sc);
                        osoblje.provjeriOib(p.povuciOib());
                    } catch (InvalidOibException ex) {
                        System.out.println(ex.getMessage());
                        continue;
                    }
                    break;
                case 2:
                    unesiStudenta(sc);
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println(osoblje.ispisi());
                    break;
                default:
            }
        } while (izbor != 5);
        osoblje.spremiUDatoteku();
    }

    private static Profesor unesiProfesora(Scanner sc) {
        System.out.println("Unesite OIB:");
        String oib = sc.nextLine();
        sc.nextLine();
        System.out.println("Unesite ime:");
        String ime = sc.nextLine();
        sc.nextLine();
        System.out.println("Unesite prezime:");
        String prezime = sc.nextLine();
        sc.nextLine();
        return new Profesor(oib, ime, prezime);
    }

    private static Student unesiStudenta(Scanner sc) {
        System.out.println("Unesite OIB:");
        String oib = sc.nextLine();
        sc.nextLine();
        System.out.println("Unesite ime:");
        String ime = sc.nextLine();
        sc.nextLine();
        System.out.println("Unesite prezime:");
        String prezime = sc.nextLine();
        sc.nextLine();
        System.out.println("Unesite broj indeksa:");
        String brojIndeksa = sc.nextLine();
        return new Student(oib, ime, prezime, brojIndeksa);
    }
}