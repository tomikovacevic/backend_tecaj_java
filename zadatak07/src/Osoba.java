public abstract class Osoba {
    private String oib;
    private Titula titula;
    private String ime;
    private String prezime;

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

    //TODO: predati delimiter
    public abstract String spremi();
}