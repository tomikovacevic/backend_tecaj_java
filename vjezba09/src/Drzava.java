public class Drzava {
    private int id;
    private String naziv;

    public Drzava(int id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "Id: " + id + " , naziv" + naziv;
    }
}
