import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Automobil extends Vozilo {
    private final byte brojVrata;
    ArrayList<Vozilo> vozilo = new ArrayList<>();

    public Automobil(String registarskiBroj, String marka, short godinaProizvodnje, byte brojVrata) {
        super(registarskiBroj, marka, godinaProizvodnje);
        try {
            if (brojVrata <= 0) {
                throw new NeispravniPodaciException();
            }
        } catch (NeispravniPodaciException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Došlo je do iznimke:" + ex.getMessage());
        }
        this.brojVrata = brojVrata;
    }

    public byte povuciBrojVrata() {
        return brojVrata;
    }

    @Override
    public String prikaziPodatke() {
        StringBuilder sb = new StringBuilder();
        //TODO dodati tip vozila
        sb.append("Registarski broj: ")
                .append(super.registarskiBroj)
                .append(", marka: ")
                .append(super.marka)
                .append(", godina proizvodnje: ")
                .append(super.godinaProizvodnje)
                .append(", tip motora: ")
                .append(brojVrata);

        return sb.toString();
    }

    //TODO treba primati line koji treba parsirati
    @Override
    public String ucitajPodatke() {
        try (BufferedReader reader = new BufferedReader(new FileReader("vozila.txt"))) {
            for (Vozilo vozilo: vozila) {

            }
        }
    }


}
