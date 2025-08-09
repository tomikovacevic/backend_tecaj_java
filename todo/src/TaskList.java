import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {
    private final String LOAD_DELIMITER = "\\|";
    private final String SAVE_DELIMITER = "|";
    private final String NEW_LINE = System.lineSeparator();
    private final String filePath = "todo.java";
    Scanner scan = new Scanner(System.in);

    public final ArrayList<Task> tasks = new ArrayList<>();

    public void addTask() {
        System.out.println("Insert a task name: ");
        String taskName = scan.nextLine();
        System.out.println("Insert a number to choose the task type: 1. " + TaskType.ONCE.toString().toLowerCase() + " or 2." + TaskType.REPEATABLE.toString().toLowerCase());
        byte choice = scan.nextByte();
        if (choice == 1) {
            tasks.
        }
        System.out.println("Insert due date: ");
        LocalDate taskDueDate = LocalDate.parse(scan.nextLine());
    }

    public void saveToFile() {
        boolean lastLine = false;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Task task : this.tasks) {
                writer.write(task.save(SAVE_DELIMITER));
                if (!tasks.isEmpty()) {
                    writer.append(NEW_LINE);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
