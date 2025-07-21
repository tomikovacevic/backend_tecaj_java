public class Profesor extends Osoba {
    public Profesor(String oib, String ime, String prezime) {
        super(oib, Titula.PROFESOR, ime, prezime);
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
                .append(noviRed);
        return sb.toString();
    }
}