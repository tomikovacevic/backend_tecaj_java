import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Upišite iznos koji vraćate kupcu:");
        double iznos = 0;
        double[] kusur = {
                500,
                200,
                100,
                50,
                20,
                10,
                5,
                2,
                1,
                0.5,
                0.2,
                0.1,
                0.05,
                0.02,
                0.01
        };
        for (int i = 0; i < kusur.length; i++) {
            int counter = 0;
            double umanjitelj = kusur[0];
            while (iznos < umanjitelj) {
                iznos -= umanjitelj;
                counter++;
            }
        }
    }
}