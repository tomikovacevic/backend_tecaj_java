import java.util.ArrayList;

public abstract class Vozilo {
    protected String registarskiBroj;
    protected final String marka;
    protected final short godinaProizvodnje;

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

    public abstract String ucitajPodatke();

    public abstract String prikaziPodatke();
}
