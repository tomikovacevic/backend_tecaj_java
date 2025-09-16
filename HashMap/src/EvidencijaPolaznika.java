import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EvidencijaPolaznika {
    private Map<String, Polaznik> polaznici;

    public EvidencijaPolaznika() {
        this.polaznici = new HashMap<>();
    }

    public boolean dodajPolaznika(String imePolaznika, String prezimePolaznika, String emailPolaznika) {
//        if(this.polaznici.containsKey(emailPolaznika)) {
//            return false;
//        } else {
//            Polaznik p = new Polaznik(imePolaznika, prezimePolaznika, emailPolaznika);
//            this.polaznici.put(emailPolaznika, p);
//            return true;
//        }
        if (!this.polaznici.containsKey(emailPolaznika)) {
            Polaznik p = new Polaznik(imePolaznika, prezimePolaznika, emailPolaznika);
            this.polaznici.put(emailPolaznika, p);
            return true;
        }
        return false;
    }

    public String ispisPolaznika() {
        StringBuilder sb = new StringBuilder();

        for (Polaznik polaznik : polaznici.values()) {
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
        if(polaznici.get())
        polaznici.get(email);
        for (Polaznik polaznik : polaznici.values()) {
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
