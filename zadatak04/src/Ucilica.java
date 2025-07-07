import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Ucilica {
    private final ArrayList<GeometrijskiLik> geometrijskiLikovi;
    DecimalFormat df = new DecimalFormat("#.##");

    public Ucilica() {
        this.geometrijskiLikovi = new ArrayList<>();
    }

    public ArrayList<GeometrijskiLik> getGeometrijskiLikovi() {
        return geometrijskiLikovi;
    }

    public void add(GeometrijskiLik lik) {
        geometrijskiLikovi.add(lik);
    }

    public void sort() {
        Collections.sort(geometrijskiLikovi);
    }

    public String write() {
        StringBuilder sb = new StringBuilder();

        for (GeometrijskiLik lik : geometrijskiLikovi) {
            sb.append(lik.getNaziv())
                    .append("|")
                    .append(df.format(lik.getPovrsina()))
                    .append("|")
                    .append(df.format(lik.getOpseg()))
                    .append("\n");
        }

        return sb.toString();
    }
}
