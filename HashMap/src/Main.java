import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EvidencijaPolaznika evidencijaPolaznika = new EvidencijaPolaznika();
        Scanner sc = new Scanner(System.in);
        int unos;
        do {
            System.out.println("Unesite željenu opciju:");
            System.out.println(printMeni());
            unos = sc.nextInt();
            sc.nextLine();
            switch (unos) {
                case 1:
                    unosPolaznika(sc, evidencijaPolaznika);
                    break;
                case 2:
                    System.out.println(evidencijaPolaznika.ispisPolaznika());
                    break;
                case 3:
                    System.out.println("Unesite email polaznika");
                    String emailPolaznika = sc.nextLine();
                    System.out.println(evidencijaPolaznika.pretraga(emailPolaznika));
                    break;
            }
        } while (unos != 4);
    }

    private static void unosPolaznika(Scanner sc, EvidencijaPolaznika evidencijaPolaznika) {
        System.out.println("Unesite ime polaznika:");
        String ime = sc.nextLine();
        System.out.println("Unesite prezime polaznika:");
        String prezime = sc.nextLine();
        System.out.println("Unesite e-mail polaznika:");
        String email = sc.nextLine();
        if (evidencijaPolaznika.dodajPolaznika(ime, prezime, email)) {
            System.out.println("Uspješan unos!");
        } else {
            System.out.println("Polaznik već postoji!");
        }
    }

    private static String printMeni() {
        //noinspection StringBufferReplaceableByString
        StringBuilder sbMeni = new StringBuilder();
        sbMeni.append("1. Unos")
                .append(System.lineSeparator())
                .append("2. Ispis")
                .append(System.lineSeparator())
                .append("3. Pretraživanje")
                .append(System.lineSeparator())
                .append("4. Nasumičan ispis")
                .append(System.lineSeparator())
                .append("5. Obrnut ispis")
                .append(System.lineSeparator())
                .append("6. Pronađi po imenu")
                .append(System.lineSeparator())
                .append("7. Izlaz");
        return sbMeni.toString();
    }
}