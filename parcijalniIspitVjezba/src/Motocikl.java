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
        StringBuilder sb = new StringBuilder();
        sb.append("Registarski broj: ")
                .append(super.registarskiBroj)
                .append(", marka: ")
                .append(super.marka)
                .append(", godina proizvodnje: ")
                .append(super.godinaProizvodnje)
                .append(", tip motora: ")
                .append(tipMotora);

        return sb.toString();
    }
}