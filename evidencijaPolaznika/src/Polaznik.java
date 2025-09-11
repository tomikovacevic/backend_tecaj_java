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
    
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    
    public void setIme(String ime) {
        this.ime = ime;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}
