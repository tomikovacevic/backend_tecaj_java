import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Osoblje {
    private final String PUTANJA = "fakultet.txt";
    private ArrayList<Osoba> osobe = new ArrayList<>();

    public void ucitajOsobeIzDatoteke() {
        try (BufferedReader reader = new BufferedReader(new FileReader((PUTANJA)))){
            List<String> redak = new ArrayList<>();
            for(Osoba osoba : osobe) {
                String[] stupci = redak.split("\\|");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Datoteka nije pronađena.");
        } catch (IOException ex) {
            System.out.println("Došlo je do iznimke: " + ex.getMessage());;
        }
    }
}
