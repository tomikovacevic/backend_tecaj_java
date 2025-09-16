import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EvidencijaPolaznika {
    private Map<String, Polaznik> polaznici;
    public EvidencijaPolaznika() {
        this.polaznici = new HashMap<>();
    }

    public boolean dodajPolaznika(String imePolaznika, String prezimePolaznika, String emailPolaznika) {
        Polaznik p = new Polaznik(imePolaznika, prezimePolaznika, emailPolaznika);
        return this.polaznici.put(emailPolaznika, p);
    }

    public String ispisPolaznika() {
        StringBuilder sb = new StringBuilder();

        for (String s : polaznici.keySet()) {
            sb.append("Ime: ")
                    .append(s.getIme())
                    .append(", prezime: ")
                    .append(polaznik.getPrezime())
                    .append(", email: ")
                    .append(polaznik.getEmail())
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }

    public String pretraga(String email) {
        for (Polaznik polaznik : polaznici.keySet()) {
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
            }
        }
        return "Polaznik sa navedenim mail-om ne postoji";
    }
}
