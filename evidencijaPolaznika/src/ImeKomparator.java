import java.util.Comparator;

public class ImeKomparator implements Comparator<Polaznik> {
    @Override
    public int compare(Polaznik o1, Polaznik o2) {
        if (o1.getEmail().compareToIgnoreCase(o2.getEmail()) == 0) {
            return 0;
        }
        int manjeIliJednako = o1.getIme().compareToIgnoreCase(o2.getIme());
        System.out.println("Uspoređujem" + o1.getIme() + " s " + o2.getIme() + " i dobivam: " + manjeIliJednako);
        return manjeIliJednako;
    }
}
