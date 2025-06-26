public class Trokut extends GeometrijskiLik {
    private final double a, b, c;

    public Trokut(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String getNaziv() {
        return "Trokut";
    }

    @Override
    public double getPovrsina() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getOpseg() {
        return a + b + c;
    }
}
