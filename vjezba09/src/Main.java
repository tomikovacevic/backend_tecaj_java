import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Drzava MANAGER");
        DrzavaRepository drzavaRepository = new DrzavaRepository();

        Scanner sc = new Scanner(System.in);
        int unos;
        do {
            System.out.println("Unesite željenu opciju:");
            System.out.println(printMeni());
            unos = sc.nextInt();
            sc.nextLine();
            switch (unos) {
                case 1:
                    System.out.println("Unesite državu:");
                    String newDrzava = sc.nextLine();
                    drzavaRepository.add(newDrzava);
                    break;
                case 2:
                    System.out.println("Unesite ID drzave koji je veći od 3 koju želite izmijeniti:");
                    int IDDrzava = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Unesite novi naziv drzave:");
                    String noviNaziv = sc.nextLine();
                    Boolean rezultat = drzavaRepository.izmjenaDrzave(IDDrzava, noviNaziv);

                    if(rezultat == null) {
                        System.out.println("Unijeli ste vrijednost koja je manje ili jednaka 3");
                    } else {
                        if (rezultat.booleanValue()) {
                            System.out.println("Uspješno ste izmjenili državu.");
                        } else {
                            System.out.println("Niste uspijeli izmjeniti državu.");
                        }
                    }

                    break;
                case 3:
                    System.out.println("Unesite ID drzave koju želite izbrisati:");
                    int IDDrzavaBrisanje = sc.nextInt();
                    sc.nextLine();
//                    drzavaRepository.brisanjeDrzave(IDDrzavaBrisanje)
                    Boolean rezultatBrisanje = drzavaRepository.brisanjeDrzave(IDDrzavaBrisanje);

                    if(rezultatBrisanje == null) {
                        System.out.println("Unijeli ste vrijednost koja je manje ili jednaka 3");
                    } else {
                        if (rezultatBrisanje.booleanValue()) {
                            System.out.println("Uspješno ste izbrisali državu.");
                        } else {
                            System.out.println("Niste uspijeli izbrisati državu.");
                        }
                    }


                    break;
                case 4:
                    ArrayList<Drzava> rezultatDrzave = drzavaRepository.dohvatiDrzave();
                    for (Drzava drzava : rezultatDrzave) {
                        System.out.println(drzava);
                    }
                    break;
                case 5:
                    ArrayList<String> dodaneDrzave = new ArrayList<>();
                    dodaneDrzave.add("a");
                    dodaneDrzave.add("b");
                    dodaneDrzave.add("c");
                    dodaneDrzave.add("d");
                    dodaneDrzave.add("e");
                    dodaneDrzave.add("f");
                    dodaneDrzave.add("g");
                    dodaneDrzave.add("h");
                    dodaneDrzave.add("i");
                    dodaneDrzave.add("j");
                    drzavaRepository.dodavanjeDrzava(dodaneDrzave);
                    break;
            }
        } while (unos != 6);
    }

    private static String printMeni() {
        //noinspection StringBufferReplaceableByString
        StringBuilder sbMeni = new StringBuilder();
        sbMeni.append("1. Unos države")
                .append(System.lineSeparator())
                .append("2. Izmjena države")
                .append(System.lineSeparator())
                .append("3. Brisanje države")
                .append(System.lineSeparator())
                .append("4. Prikaz svih država")
                .append(System.lineSeparator())
                .append("5. Dodavanje država")
                .append(System.lineSeparator())
                .append("6. Izlaz");
        return sbMeni.toString();
    }
}