public abstract class Osoba {
    protected final String oib;
    protected final Titula titula;
    protected final String ime;
    protected final String prezime;

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

    protected String povuciOib() {
        return oib;
    }

    public abstract String spremi(String delimiter, String noviRed);
}