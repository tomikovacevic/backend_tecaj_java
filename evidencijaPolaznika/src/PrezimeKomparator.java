import java.util.Comparator;

public class PrezimeKomparator implements Comparator<Polaznik> {
    @Override
    public int compare(Polaznik o1, Polaznik o2) {
        if(o1.getEmail().compareToIgnoreCase(o2.getEmail()) == 0) {
            return 0;
        }
        int manjeIliJednako = o1.getPrezime().compareToIgnoreCase(o2.getPrezime());
        System.out.println("Uspoređujem" + o1.getPrezime() + " s " + o2.getPrezime() + " i dobivam: " + manjeIliJednako);
        return manjeIliJednako;
    }
}
