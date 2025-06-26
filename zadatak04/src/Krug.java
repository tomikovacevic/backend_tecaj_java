public class Krug extends GeometrijskiLik {
    private final double radijus;

    public Krug(double radijus) {
        this.radijus = radijus;
    }

    @Override
    public String getNaziv() {
        return "Krug";
    }

    @Override
    public double getPovrsina() {
        return Math.pow(radijus, 2) * Math.PI;
    }

    @Override
    public double getOpseg() {
        return 2 * radijus * Math.PI;
    }
}
