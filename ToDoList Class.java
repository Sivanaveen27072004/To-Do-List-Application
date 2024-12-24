import java.io.*;
import java.util.*;

public class ToDoList {
    private List<Task> tasks;
    private String filename;

    // Constructor
    public ToDoList(String filename) {
        this.filename = filename;
        this.tasks = new ArrayList<>();
        loadTasksFromFile();
    }

    // Add a task
    public void addTask(String description, String dueDate) {
        tasks.add(new Task(description, dueDate));
        saveTasksToFile();
    }

    // Mark a task as completed
    public void completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).completeTask();
            saveTasksToFile();
        } else {
            System.out.println("Invalid task number!");
        }
    }

    // Delete a task
    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            saveTasksToFile();
        } else {
            System.out.println("Invalid task number!");
        }
    }

    // Display all tasks
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + 1 + ". " + tasks.get(i));
            }
        }
    }

    // Save tasks to file
    private void saveTasksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Task task : tasks) {
                writer.write(task.getDescription() + "\n");
                writer.write(task.getDueDate() + "\n");
                writer.write(task.isCompleted() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    // Load tasks from file
    private void loadTasksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String description;
            while ((description = reader.readLine()) != null) {
                String dueDate = reader.readLine();
                boolean isCompleted = Boolean.parseBoolean(reader.readLine());
                Task task = new Task(description, dueDate);
                if (isCompleted) {
                    task.completeTask();
                }
                tasks.add(task);
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }
}
