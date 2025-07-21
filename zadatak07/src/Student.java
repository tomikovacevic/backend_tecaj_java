public class Student extends Osoba {
    private final String brojIndeksa;

    public Student(String oib, String ime, String prezime, String brojIndeksa) {
        super(oib, Titula.STUDENT, ime, prezime);
        this.brojIndeksa = brojIndeksa;
    }

    public String povuciBrojIndeksa() {
        return brojIndeksa;
    }

    @Override
    public String spremi(String delimiter, String noviRed) {
        StringBuilder sb = new StringBuilder();
        sb.append(super.oib)
                .append(delimiter)
                .append(super.titula.povuciImeTitule())
                .append(delimiter)
                .append(super.ime)
                .append(delimiter)
                .append(super.prezime)
                .append(delimiter)
                .append(this.brojIndeksa)
                .append(noviRed);
        return sb.toString();
    }
}
