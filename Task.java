public class Task {
    private String description;
    private String dueDate;
    private boolean isCompleted;

    // Constructor
    public Task(String description, String dueDate) {
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = false;
    }

    // Getter methods
    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    // Method to mark task as completed
    public void completeTask() {
        this.isCompleted = true;
    }

    // Method to represent the task as a String (for saving to file)
    @Override
    public String toString() {
        return description + " | " + (isCompleted ? "Completed" : "Pending") + (dueDate != null ? " | Due: " + dueDate : "");
    }
}
