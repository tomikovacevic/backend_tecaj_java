public class Profesor extends Osoba {
    public Profesor(String oib, String ime, String prezime) {
        super(oib, Titula.PROFESOR, ime, prezime);
    }

    @Override
    public String spremi() {
        StringBuilder sb = new StringBuilder();
        sb.append()
                .append("\\|")
                .append(this.titula)
                .append()
    }
}