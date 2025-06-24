public class Trokut extends GeometrijskiLik {
    private double a;
    private double b;
    private double c;

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
        return 0.25f * Math.sqrt((a + b + c) * (-a + b + c) * (a - b + c) * (a + b - c));
    }

    @Override
    public double getOpseg() {
        return a + b + c;
    }
}
