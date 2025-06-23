public class Pravokutnik extends GeometrijskiLik {
    private double a;
    private double b;

    @Override
    public String getNaziv() {
        return "Pravokutnik";
    }

    @Override
    public double getPovrsina() {
        return 0.25;// * Math.sqrt()
    }

    @Override
    public double getOpseg() {
        return 0;
    }
}
