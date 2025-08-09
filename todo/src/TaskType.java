public enum TaskType {
    ONCE((byte) 1),
    REPEATABLE((byte) 2);

    private final byte taskTypeNumber;

    TaskType(byte taskTypeNumber) {
        this.taskTypeNumber = taskTypeNumber;
    }

    public static TaskType getTaskTypeNumber(byte type) {
        for (TaskType taskType : TaskType.values()) {
            if (taskType.taskTypeNumber == type) {
                return taskType;
            }
        }
        throw new IllegalArgumentException("This task type number doesn't exist: " + type);
    }
}
