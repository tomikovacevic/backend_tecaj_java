public class Main {
    public static void main(String[] args) {
        // pomnoži prvi element svakog drugog elementa
        int[][] x = {
                {202, 118, 126, 246, 183},
                {200, 141, 76, 70, 41},
                {98, 263, 105, 288, 263},
                {122, 228, 106, 105, 155},
                {92, 24, 72, 268, 51},
                {28, 138, 6, 39, 129},
                {52, 121, 78, 65, 58}
        };

        for (int i = 1; i < x.length; i += 2) {
            x[i][0] *= 2;
            for (int j = 0; j < x[i].length; j++) {
                if (j > 0) {
                    System.out.print(", ");
                }
                System.out.print(x[i][j]);
            }
            if (i < x[i].length - 1) {
                System.out.print(",");
            }
            System.out.println();
        }
    }
}