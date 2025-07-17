import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Osoblje {
    private final String DELIMITER = "\\|";
    private final String NOVI_RED = System.lineSeparator();
    private ArrayList<Osoba> osobe = new ArrayList<>();
    private final String PUTANJA = "fakultet.txt";

    public void ucitajOsobeIzDatoteke() {
        try (BufferedReader reader = new BufferedReader(new FileReader((PUTANJA)))) {
            List<String> redovi = reader.lines().toList();
            for (String redak : redovi) {
                String[] kolone = redak.split(DELIMITER);
                String oib = kolone[0];
                String titula = kolone[1];
                String ime = kolone[2];
                String prezime = kolone[3];
                Titula imeTitule = Titula.izNaziva(titula);
                if (imeTitule.equals(Titula.PROFESOR)) {
                    Profesor profesor = new Profesor(oib, ime, prezime);
                    this.osobe.add(profesor);
                } else if (imeTitule.equals(Titula.STUDENT)) {
                    String brojIndeksa = kolone[4];
                    Student student = new Student(oib, ime, prezime, brojIndeksa);
                    this.osobe.add(student);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Datoteka nije pronađena.");
        } catch (IOException ex) {
            System.out.println("Došlo je do iznimke: " + ex.getMessage());
        }
    }

    public String ispisi() {
        int brojProfesora = 0;
        int brojStudenata = 0;
        //TODO: add sorting using comparable, therefore only 1 StringBuilder will be needed
        StringBuilder sbProfesori = new StringBuilder();
        StringBuilder sbStudenti = new StringBuilder();
        StringBuilder sbIspis = new StringBuilder();

        for (Osoba osoba : osobe) {
            if (osoba instanceof Profesor profesor) {
                brojProfesora++;
                sbProfesori.append("OIB: ")
                        .append(profesor.povuciOib())
                        .append(", ")
                        .append(("ime i prezime: "))
                        .append(profesor.povuciIme())
                        .append(" ")
                        .append(profesor.povuciPrezime())
                        .append(NOVI_RED);
            } else if (osoba instanceof Student student) {
                brojStudenata++;
                sbStudenti.append("OIB: ")
                        .append(student.povuciOib())
                        .append(", ")
                        .append(("ime i prezime: "))
                        .append(student.povuciIme())
                        .append(" ")
                        .append(student.povuciPrezime())
                        .append(", ")
                        .append("broj indeksa: ")
                        .append(student.povuciBrojIndeksa())
                        .append(NOVI_RED);
            }
        }

        sbIspis.append("Profesori (")
                .append(brojProfesora)
                .append("):")
                .append(NOVI_RED)
                .append(sbProfesori)
                .append("Studenti (")
                .append(brojStudenata)
                .append("):")
                .append(NOVI_RED)
                .append(sbStudenti);

        return sbIspis.toString();
    }

    public void dodajOsobu(Osoba osoba) {
        osobe.add(osoba);
    }

    public void provjeriOib(String oib) throws InvalidOibException {
        for (Osoba osoba : osobe) {
            if (osoba.povuciOib().equals(oib)) {
                throw new InvalidOibException();
            }
        }
    }

    public void spremiUDatoteku() {
        try (PrintWriter printWriter = new PrintWriter(PUTANJA)) {
            for (Osoba osoba : this.osobe) {
                printWriter.println(osoba);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Datoteka nije pronađena: " + ex.getMessage());
        }
    }
}