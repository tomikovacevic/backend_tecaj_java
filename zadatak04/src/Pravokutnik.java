public class Pravokutnik extends GeometrijskiLik {
    private final double a, b;

    public Pravokutnik(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String getNaziv() {
        return "Pravokutnik";
    }

    @Override
    public double getPovrsina() {
        return a * b;
    }

    @Override
    public double getOpseg() {
        return (2 * (a + b));
    }

    @Override
    public String toString() {
        return this.getNaziv() + "|" + this.a + "|" + this.b;
    }
}
