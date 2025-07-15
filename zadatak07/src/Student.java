public class Student extends Osoba {
    private String oib;

    public Student(String ime, String prezime, String oib) {
        super(Titula.STUDENT, ime, prezime);
        this.oib = oib;
    }

    public String getOib() {
        return oib;
    }
}
