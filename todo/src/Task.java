import java.time.LocalDate;

public class Task {
    private int taskId;
    private String taskName, taskDescription;
    private LocalDate taskDateCreated, taskDueDate;
    private boolean taskCompleted;
    private TaskType taskType;

    public Task(int taskId, String taskName, String taskDescription, TaskType taskType, LocalDate taskDateCreated, LocalDate taskDueDate, boolean taskCompleted) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskType = taskType;
        this.taskDateCreated = taskDateCreated;
        this.taskDueDate = taskDueDate;
        this.taskCompleted = taskCompleted;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public LocalDate getTaskDateCreated() {
        return taskDateCreated;
    }

    public LocalDate getTaskDueDate() {
        return taskDueDate;
    }

    public boolean isTaskCompleted() {
        return taskCompleted;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public void setTaskDateCreated(LocalDate taskDateCreated) {
        this.taskDateCreated = taskDateCreated;
    }

    public void setTaskDueDate(LocalDate taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public void setTaskCompleted(boolean taskCompleted) {
        this.taskCompleted = taskCompleted;
    }

    public String save(String delimiter) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.taskId)
                .append(delimiter)
                .append(this.taskName)
                .append(delimiter)
                .append(this.taskDescription)
                .append(delimiter)
                .append(this.taskType)
                .append(delimiter)
                .append(this.taskDateCreated)
                .append(delimiter)
                .append(this.taskDueDate)
                .append(delimiter)
                .append(this.taskCompleted);

        return sb.toString();
    }
}