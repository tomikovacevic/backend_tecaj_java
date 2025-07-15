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
                String titula = redak.split(DELIMITER)[0];
                String ime = redak.split(DELIMITER)[1];
                String prezime = redak.split(DELIMITER)[2];
                if (titula.equalsIgnoreCase("profesor")) {
                    Profesor profesor = new Profesor(ime, prezime);
                    this.osobe.add(profesor);
                } else if (titula.equalsIgnoreCase("student")) {
                    String oib = redak.split(DELIMITER)[3];
                    Student student = new Student(ime, prezime, oib);
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
        StringBuilder sbProfesori = new StringBuilder();
        StringBuilder sbStudenti = new StringBuilder();
        StringBuilder sbIspis = new StringBuilder();

        for (Osoba osoba : osobe) {
            if (osoba instanceof Profesor) {
                brojProfesora++;
                sbProfesori.append(osoba.getIme())
                        .append(" ")
                        .append(osoba.getPrezime())
                        .append(" ")
                        .append("\n");
            } else if (osoba instanceof Student) {
                brojStudenata++;
                sbStudenti.append(osoba.getIme())
                        .append(" ")
                        .append(osoba.getPrezime())
                        .append("\n");
            }
        }
        sbIspis.append("Profesori (")
                .append(brojProfesora)
                .append("):")
                .append("\n")
                .append(sbProfesori)
                .append("Studenti (")
                .append(brojStudenata)
                .append("):")
                .append("\n")
                .append(sbStudenti);

        return sbIspis.toString();
    }
}
