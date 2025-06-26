import java.text.DecimalFormat;
import java.util.ArrayList;

public class Ucilica {
    private final ArrayList<GeometrijskiLik> geometrijskiLikovi;
    DecimalFormat df = new DecimalFormat("#.##");

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
                    .append(", Površina iznosi: ")
                    .append(df.format(lik.getPovrsina()))
                    .append(" Opseg iznosi: ")
                    .append(df.format(lik.getOpseg()))
                    .append("\n");
        }

        return sb.toString();
    }
}
