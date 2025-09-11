import java.util.ArrayList;

public class EvidencijaPolaznika {
    private ArrayList<Polaznik> polaznici;

    public EvidencijaPolaznika() {
        this.polaznici = new ArrayList<>();
    }

    public void dodajPolaznika(String imePolaznika, String prezimePolaznika, String emailPolaznika) {
        this.polaznici.add(new Polaznik(imePolaznika, prezimePolaznika, emailPolaznika));
    }

    public String ispisPolaznika() {
        StringBuilder sb = new StringBuilder();

        for (Polaznik polaznik : polaznici) {
            sb.append("Ime: ")
                    .append(polaznik.getIme())
                    .append(", prezime: ")
                    .append(polaznik.getPrezime())
                    .append(", email: ")
                    .append(polaznik.getEmail())
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }

    public String pretraga(String email) {
        for (Polaznik polaznik : polaznici) {
            if (polaznik.getEmail().equalsIgnoreCase(email)) {
                //noinspection StringBufferReplaceableByString
                StringBuilder sbPodaci = new StringBuilder();
                sbPodaci.append("Ime: ")
                        .append(polaznik.getIme())
                        .append(", prezime: ")
                        .append(polaznik.getPrezime())
                        .append(", email: ")
                        .append(polaznik.getEmail())
                        .append(System.lineSeparator());
                return sbPodaci.toString();
            };
        }
        return "Polaznik sa navedenim mail-om ne postoji";
    }
}
