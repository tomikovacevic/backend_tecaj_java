public class Trokut extends GeometrijskiLik {
    private float a;
    private float b;
    private float c;

    public Trokut(float a, float b, float c) {
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
