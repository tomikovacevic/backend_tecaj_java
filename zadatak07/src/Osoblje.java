import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Osoblje {
    private final String PUTANJA = "fakultet.txt";
    private final String DELIMITER = "\\|";
    private ArrayList<Osoba> osobe = new ArrayList<>();

    public void ucitajOsobeIzDatoteke() {
        try (BufferedReader reader = new BufferedReader(new FileReader((PUTANJA)))) {
            List<String> redovi = reader.lines().toList();
            for (String redak : redovi) {
                String[] kolone = redak.split(DELIMITER);
                String oib = kolone[0];
                String titula = kolone[1];
                String ime = kolone[2];
                String prezime = kolone[3];
                if (titula.equalsIgnoreCase("profesor")) {
                    Profesor profesor = new Profesor(oib, ime, prezime);
                    this.osobe.add(profesor);
                } else if (titula.equalsIgnoreCase("student")) {
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
                sbProfesori.append(profesor.povuciIme())
                        .append(" ")
                        .append(profesor.povuciPrezime())
                        .append(System.lineSeparator());
            } else if (osoba instanceof Student student) {
                brojStudenata++;
                sbStudenti.append(student.povuciIme())
                        .append(" ")
                        .append(student.povuciPrezime())
                        .append(System.lineSeparator());
            }
        }

        sbIspis.append(Titula.PROFESOR.imeTitule)
                .append("i (")
                .append(brojProfesora)
                .append("):")
                .append(System.lineSeparator())
                .append(sbProfesori)
                .append(Titula.STUDENT.imeTitule)
                .append("i (")
                .append(brojStudenata)
                .append("):")
                .append(System.lineSeparator())
                .append(sbStudenti);

        return sbIspis.toString();
    }

    public void dodajOsobu(Osoba osoba) {
        osobe.add(osoba);
    }

    public boolean isOibValid(String oib) {

    }
}