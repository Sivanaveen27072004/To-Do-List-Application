import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList todoList = new ToDoList("tasks.txt");  // Task file name

        while (true) {
            System.out.println("\nTo-Do List Application");
            System.out.println("1. View Tasks");
            System.out.println("2. Add Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    todoList.displayTasks();
                    break;
                case 2:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter task due date (optional, leave blank if none): ");
                    String dueDate = scanner.nextLine();
                    todoList.addTask(description, dueDate.isEmpty() ? null : dueDate);
                    break;
                case 3:
                    System.out.print("Enter task number to mark as completed: ");
                    int completeIndex = scanner.nextInt() - 1;
                    todoList.completeTask(completeIndex);
                    break;
                case 4:
                    System.out.print("Enter task number to delete: ");
                    int deleteIndex = scanner.nextInt() - 1;
                    todoList.deleteTask(deleteIndex);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
