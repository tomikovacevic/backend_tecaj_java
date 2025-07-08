import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Vozilo {
    private final String registarskiBroj, marka;
    private final short godinaProizvodnje;

    public Vozilo(String registarskiBroj, String marka, short godinaProizvodnje) {
        try {
            if (godinaProizvodnje <= 0) {
                throw new NeispravniPodaciException();
            }
        } catch (NeispravniPodaciException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Došlo je do iznimke:" + ex.getMessage());
        }

        this.registarskiBroj = registarskiBroj;
        this.marka = marka;
        this.godinaProizvodnje = godinaProizvodnje;
    }

    public String povuciRegistarskiBroj() {
        return registarskiBroj;
    }

    public String povuciMarku() {
        return marka;
    }

    public short povuciGodinuProizvodnje() {
        return godinaProizvodnje;
    }

    public static String ucitajPodatke() {
        return null;
    }

    public abstract String prikaziPodatke();
}
