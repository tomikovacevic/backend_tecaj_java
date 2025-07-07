import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Molimo Vas da unesete putanju do izvorne datoteke:");
        String sourcePath = sc.nextLine();

        System.out.println("Molimo Vas da unesete putanju do destinacijske datoteke:");
        String destinationPath = sc.nextLine();

        File destinationFile = new File(destinationPath);

        if (destinationFile.exists()) {
            System.out.println("Želite li izbrisati destinacijsku datoteku? (y/n)");
            String willBeDeleted = sc.nextLine();

            if (willBeDeleted.equalsIgnoreCase("y") && destinationFile.delete()) {
                System.out.println("Datoteka uspješno izbrisana.");
            } else {
                System.out.println("Datoteku nije moguće izbrisati.");
            }
        }

        copy(sourcePath, destinationPath);
    }

    private static void copy(String sourcePath, String destinationPath) {
        try (FileInputStream fileInputStream = new FileInputStream(sourcePath);
             FileOutputStream fileOutputStream = new FileOutputStream(destinationPath)) {
            byte[] buffer = new byte[1024];

            int total;
            while ((total = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, total);
            }
        } catch (Exception e) {
            System.out.println("Došlo je do iznimke: " + e.getMessage());
            e.printStackTrace();
        }
    }
}