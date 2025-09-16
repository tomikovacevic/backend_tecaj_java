//public class Polaznik implements Comparable<Polaznik> {
public class Polaznik {
    private String ime, prezime, email;

    public Polaznik(String ime, String prezime, String email) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getEmail() {
        return email;
    }

//    @Override
//    public int compareTo(Polaznik other) {
//        if(this.email.compareToIgnoreCase(other.email) == 0) {
//            return 0;
//        }
//        int manjeIliJednako = this.prezime.compareToIgnoreCase(other.prezime);
//        System.out.println("Uspoređujem" + this.prezime + " s " + other.prezime + " i dobivam: " + manjeIliJednako);
//        return manjeIliJednako;
//    }
}
