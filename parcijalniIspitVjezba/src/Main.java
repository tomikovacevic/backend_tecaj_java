public class Main {
    public static void main(String[] args) {
        EvidencijaVozila evidencijaVozila = new EvidencijaVozila();

        try {
            Automobil auto1 = new Automobil("ZG1234AB", "Toyota", (short)2015, (byte)4);
            Motocikl moto1 = new Motocikl("ZG5678CD", "Yamaha", (short)2018, "Sportski");

            evidencijaVozila.dodajVozilo(auto1);
            evidencijaVozila.dodajVozilo(moto1);

            evidencijaVozila.spremiPodatkeUDatoteku("vozila.txt");

            evidencijaVozila.ucitajPodatkeIzDatoteke("vozila.txt");

            evidencijaVozila.prikaziSvaVozila();

        } catch (NeispravniPodaciException ex) {
            System.out.printf("Došlo je do iznimke:" + ex.getMessage());
        }
    }
}