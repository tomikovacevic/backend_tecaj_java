import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GeometrijskiLikManager {
    public static ArrayList<GeometrijskiLik> load() {
        ArrayList<GeometrijskiLik> likovi = new ArrayList<>();

        try (FileReader fileReader = new FileReader("likovi.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            List<String> lines = bufferedReader.lines().toList();

            for(String line: lines) {
                String[] kolone = line.split("\\|");

                String naziv = kolone[0];

                switch (naziv) {
                    case "Krug":
                        Krug krug = new Krug(Double.parseDouble(kolone[1]));
                        likovi.add(krug);
                        break;
                    case "Trokut":
                        double at = Double.parseDouble(kolone[1]);
                        double bt = Double.parseDouble(kolone[2]);
                        double ct = Double.parseDouble(kolone[3]);
                        Trokut trokut = new Trokut(at,bt,ct);
                        likovi.add(trokut);
                        break;
                    case "Pravokutnik":
                        double ap = Double.parseDouble(kolone[1]);
                        double bp = Double.parseDouble(kolone[2]);
                        Pravokutnik pravokutnik = new Pravokutnik(ap, bp);
                        likovi.add(pravokutnik);
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Oops. Nisam uspio učitati geometrijske likove." + e.getMessage());
        }
        return likovi;
    }

    public static void save(ArrayList<GeometrijskiLik> likovi) {
        File file = new File("likovi.txt");
        try (PrintWriter pw = new PrintWriter(file)) {
            for (GeometrijskiLik lik : likovi) {
                pw.println(lik);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Oops. File not found.");
        }
    }
}
