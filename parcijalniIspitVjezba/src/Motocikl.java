public class Motocikl extends Vozilo {
    private final String tipMotora;

    public Motocikl(String registarskiBroj, String marka, short godinaProizvodnje, String tipMotora) {
        super(registarskiBroj, marka, godinaProizvodnje);
        try {
            if (tipMotora.isEmpty()) {
                throw new NeispravniPodaciException();
            }
        } catch (NeispravniPodaciException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Došlo je do iznimke:" + ex.getMessage());
        }
        this.tipMotora = tipMotora;
    }

    public String povuciTipMotora() {
        return tipMotora;
    }

    @Override
    public String prikaziPodatke() {
        return "Registarski broj: " +
                povuciRegistarskiBroj() +
                ", marka: " +
                povuciMarku() +
                ", godina proizvodnje: " +
                povuciGodinuProizvodnje() +
                ", tip motora: " +
                povuciTipMotora() +
                "\n";
    }
}