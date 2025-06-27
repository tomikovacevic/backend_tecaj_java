public abstract class GeometrijskiLik implements Comparable<GeometrijskiLik> {
    public abstract String getNaziv();

    public abstract double getPovrsina();

    public abstract double getOpseg();

    @Override
    public int compareTo(GeometrijskiLik other) {
        return Double.compare(getPovrsina(), other.getPovrsina());
    }
}
