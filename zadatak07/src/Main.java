import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String NOVI_RED = System.lineSeparator();
        StringBuilder sbMeni = new StringBuilder();
        Osoblje osoblje = new Osoblje();
        Scanner sc = new Scanner(System.in);
        sbMeni.append("Unesite brojku ispred željene opcije:")
                .append(NOVI_RED)
                .append("1. Unos profesora")
                .append(NOVI_RED)
                .append("2. Unos studenta")
                .append(NOVI_RED)
                .append("3. Filtriranje")
                .append(NOVI_RED)
                .append("4. Ispis");

        System.out.println(sbMeni);
        byte izbor = sc.nextByte();

        while (izbor >= 1 && izbor <= 4) {
            System.out.println("Unesite ime:");
            try {
                System.out.println("Unesite OIB:");
                String oib = sc.nextLine();
                osoblje.provjeriOib(oib);
            } catch (InvalidOibException ex) {
                System.out.println(ex.getMessage());
                continue;
            }
            String ime = sc.nextLine();
            String prezime = sc.nextLine();

            switch (izbor) {
                case 1:
                    osoblje.dodajOsobu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    osoblje.ucitajOsobeIzDatoteke();
                    System.out.println(osoblje.ispisi());
                    break;
                default:
                    break;
            }
        }
    }
}