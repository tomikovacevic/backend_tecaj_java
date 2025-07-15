public abstract class Osoba {
    protected Titula titula;
    protected String ime;
    protected String prezime;

    public Osoba(Titula titula, String ime, String prezime) {
        this.titula = titula;
        this.ime = ime;
        this.prezime = prezime;
    }

    public Titula getTitula() {
        return titula;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }
}