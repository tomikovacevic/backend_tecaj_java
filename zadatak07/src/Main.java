import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Osoblje osoblje = new Osoblje();
        //TODO separate menu display into a method
        final String NOVI_RED = System.lineSeparator();
        StringBuilder sbIzbornik = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        byte izbor;
        osoblje.ucitajOsobeIzDatoteke();

        sbIzbornik.append("Unesite brojku ispred željene opcije:")
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
            System.out.println(sbIzbornik);
            izbor = sc.nextByte();
            sc.nextLine();
            switch (izbor) {
                case 1:
                    Profesor profesor = unesiProfesora(sc);
                    try {
                        osoblje.provjeriOib(profesor.povuciOib());
                    } catch (InvalidOibException ex) {
                        System.out.println(ex.getMessage());
                        continue;
                    }
                    osoblje.dodajOsobu(profesor);
                    osoblje.spremiUDatoteku();
                    break;
                case 2:
                    Student student = unesiStudenta(sc);
                    try {
                        osoblje.provjeriOib(student.povuciOib());
                    } catch (InvalidOibException ex) {
                        System.out.println(ex.getMessage());
                        continue;
                    }
                    osoblje.dodajOsobu(student);
                    osoblje.spremiUDatoteku();
                    break;
                case 3:
                    filterIzbornik(sc, NOVI_RED, osoblje);
                    break;
                case 4:
                    System.out.println(osoblje.ispisi());
                    System.out.println("Pritisnite \"Enter\" za povratak na glavni izbornik...");
                    sc.nextLine();
                    break;
                default:
            }
        } while (izbor != 5);
    }

//    TODO: move the methods to osoblje; Try to make a single method with conditions for Profesor and Student
    private static Profesor unesiProfesora(Scanner sc) {
        System.out.println("Unesite OIB:");
        String oib = sc.nextLine();
        System.out.println("Unesite ime:");
        String ime = sc.nextLine();
        System.out.println("Unesite prezime:");
        String prezime = sc.nextLine();
        return new Profesor(oib, ime, prezime);
    }

    private static Student unesiStudenta(Scanner sc) {
        System.out.println("Unesite OIB:");
        String oib = sc.nextLine();
        System.out.println("Unesite ime:");
        String ime = sc.nextLine();
        System.out.println("Unesite prezime:");
        String prezime = sc.nextLine();
        System.out.println("Unesite broj indeksa:");
        String brojIndeksa = sc.nextLine();
        return new Student(oib, ime, prezime, brojIndeksa);
    }

    private static void filterIzbornik(Scanner sc, String noviRed, Osoblje osoblje) {
        byte izborFilter;
        StringBuilder sbFilter = new StringBuilder();
        sbFilter.append("Unesite brojku ispred željene opcije:")
                .append(noviRed)
                .append("1. Filtriranje po imenu")
                .append(noviRed)
                .append("2. Filtriranje po prezimenu")
                .append(noviRed)
                .append("3. Izlaz");

        do {
            System.out.println(sbFilter);
            izborFilter = sc.nextByte();
            sc.nextLine();

            switch (izborFilter) {
                case 1:
                    System.out.println("Unesite ime po kojemu želite filtrirati rezultat:");
                    String ime = sc.nextLine();
                    System.out.println(osoblje.filtrirajPoImenu(ime));
                    System.out.println("Pritisnite \"Enter\" za povratak na glavni izbornik...");
                    sc.nextLine();
                    break;
                case 2:
                    System.out.println("Unesite prezime po kojemu želite filtrirati rezultat:");
                    String prezime = sc.nextLine();
                    System.out.println(osoblje.filtrirajPoPrezimenu(prezime));
                    System.out.println("Pritisnite \"Enter\" za povratak na glavni izbornik...");
                    sc.nextLine();
                    break;
                case 3:
                    break;
                default:
            }
        } while (izborFilter != 3);
    }
}