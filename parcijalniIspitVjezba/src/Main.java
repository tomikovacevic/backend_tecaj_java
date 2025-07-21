public class Main {
    public static void main(String[] args) {
        EvidencijaVozila evidencijaVozila = new EvidencijaVozila();
        evidencijaVozila.ucitajPodatkeIzDatoteke("vozila.txt");
        try {
            Automobil automobil1 = new Automobil("ZG1234AB", "Toyota", (short)2015, (byte)4);
            Motocikl motocikl1 = new Motocikl("ZG5678CD", "Yamaha", (short)2018, "V6");

            evidencijaVozila.dodajVozilo(automobil1);
            evidencijaVozila.dodajVozilo(motocikl1);

            evidencijaVozila.spremiPodatkeUDatoteku("vozila.txt");

            evidencijaVozila.prikaziSvaVozila();

        } catch (NeispravniPodaciException ex) {
            System.out.printf("Došlo je do iznimke:" + ex.getMessage());
        }
    }
}