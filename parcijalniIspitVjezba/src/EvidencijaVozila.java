import java.io.*;
import java.util.ArrayList;

public class EvidencijaVozila {
    private final ArrayList<Vozilo> vozila;

    public EvidencijaVozila() {
        vozila = new ArrayList<>();
    }

    public void dodajVozilo(Vozilo vozilo) {
        vozila.add(vozilo);
    }

    public void spremiPodatkeUDatoteku(String datoteka) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(datoteka))) {
            for (Vozilo vozilo : vozila) {
                if (vozilo instanceof Automobil automobil) {
                    writer.write("Automobil,"
                            + automobil.povuciRegistarskiBroj() + ","
                            + automobil.povuciMarku() + ","
                            + automobil.povuciGodinuProizvodnje() + ","
                            + automobil.povuciBrojVrata());
                    writer.newLine();
                } else if (vozilo instanceof Motocikl motocikl) {
                    writer.write("Motocikl,"
                            + motocikl.povuciRegistarskiBroj() + ","
                            + motocikl.povuciMarku() + ","
                            + motocikl.povuciGodinuProizvodnje() + ","
                            + motocikl.povuciTipMotora());
                    writer.newLine();
                }
            }
        } catch (IOException ex) {
            System.out.println("Došlo je do iznimke: " + ex.getMessage());
        }
    }

    public void ucitajPodatkeIzDatoteke(String datoteka) {
        try (BufferedReader reader = new BufferedReader(new FileReader(datoteka))) {
            String redak;
            while((redak = reader.readLine()) != null) {
                String[] element = redak.split(",");
                String tipVozila = element[0];
                String registarskiBroj = element[1];
                String marka = element[2];
                short godinaProizvodnje = Short.parseShort(element[3]);

                if (tipVozila.equals("Automobil")) {
                    byte brojVrata = Byte.parseByte(element[4]);
                    vozila.add(new Automobil(registarskiBroj, marka, godinaProizvodnje, brojVrata));
                } else if (tipVozila.equals("Motocikl")) {
                    String tipMotora = element[4];
                    vozila.add(new Motocikl(registarskiBroj, marka, godinaProizvodnje, tipMotora));
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Datoteka nije pronađena.");
        } catch (IOException ex) {
            System.out.println("Došlo je do iznimke: " + ex.getMessage());
        }
    }

    public void prikaziSvaVozila() {
        for (Vozilo vozilo : vozila) {
            System.out.println(vozilo.prikaziPodatke());
        }
    }
}
