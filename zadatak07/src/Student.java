public class Student extends Osoba {
    private String brojIndeksa;

    public Student(String oib, String ime, String prezime, String brojIndeksa) {
        super(oib, Titula.STUDENT, ime, prezime);
        this.brojIndeksa = brojIndeksa;
    }

    public String povuciBrojIndeksa() {
        return brojIndeksa;
    }
}
