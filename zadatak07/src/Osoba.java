public abstract class Osoba {
    protected String oib;
    protected Titula titula;
    protected String ime;
    protected String prezime;

    public Osoba(String oib, Titula titula, String ime, String prezime) {
        this.oib = oib;
        this.titula = titula;
        this.ime = ime;
        this.prezime = prezime;
    }

    protected String povuciIme() {
        return ime;
    }

    protected String povuciPrezime() {
        return prezime;
    }

    protected String povuciOib() { return oib; }
}