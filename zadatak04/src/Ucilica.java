import java.util.ArrayList;

public class Ucilica {
    private ArrayList<GeometrijskiLik> geometrijskiLikovi;

    public Ucilica() {
        this.geometrijskiLikovi = new ArrayList<>();
    }

    public void add(GeometrijskiLik lik) {
        geometrijskiLikovi.add(lik);
    }

    public void sort() {

    }

    public String get() {
        StringBuilder sb = new StringBuilder();

        for (GeometrijskiLik lik : geometrijskiLikovi) {
            sb.append(lik.getNaziv())
                    .append(" ")
                    .append("Površina: ")
                    .append(lik.getPovrsina())
                    .append("Opseg: ")
                    .append(" ")
                    .append(lik.getOpseg())
                    .append("\n");
        }

        return sb.toString();
    }
}
