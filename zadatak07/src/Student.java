public class Student extends Osoba {
    private String OIB;

    public Student(String ime, String prezime, String titula, String oib) {
        super(ime, prezime, titula);
        this.titula = titula;
    }
}
