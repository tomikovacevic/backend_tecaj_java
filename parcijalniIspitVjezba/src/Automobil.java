public class Automobil extends Vozilo {
    private final byte brojVrata;

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
        return "Registarski broj: " +
                povuciRegistarskiBroj() +
                ", marka: " +
                povuciMarku() +
                ", godina proizvodnje: " +
                povuciGodinuProizvodnje() +
                ", broj vrata: " +
                povuciBrojVrata() +
                "\n";
    }
}
