import java.util.ArrayList;
import java.util.Scanner;

public class Task3 {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Task> taskList = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n----- TASK MANAGER -----");
            System.out.println("1. CREATE TASK");
            System.out.println("2. READ TASKS");
            System.out.println("3. UPDATE TASK");
            System.out.println("4. DELETE TASK");
            System.out.println("0. EXIT");
            System.out.print("Choose Option: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1: // CREATE
                    Task t = new Task();

                    System.out.print("Enter Task ID: ");
                    t.id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Task Title: ");
                    t.title = sc.nextLine();

                    System.out.print("Enter Task Description: ");
                    t.description = sc.nextLine();

                    System.out.print("Enter Task Status (Pending/Completed): ");
                    t.status = sc.nextLine();

                    taskList.add(t);
                    System.out.println("✔ Task Added Successfully");
                    break;

                case 2: // READ (Search by ID)

                    System.out.print("Enter Id to show record: ");
                    int display_id = sc.nextInt();

                    boolean found = false;

                    if (taskList.isEmpty()) {
                        System.out.println("❌ No Tasks Available");
                    } else {
                        for (Task task : taskList) {
                            if (task.id == display_id) {
                                System.out.println(
                                    "ID: " + task.id +
                                    " | Title: " + task.title +
                                    " | Description: " + task.description +
                                    " | Status: " + task.status
                                );
                                found = true;
                                break; // stop searching once found
                            }
                        }

                        if (!found) {
                            System.out.println("❌ You Entered Wrong ID");
                        }
                    }
                    break;


                case 3: // UPDATE
                    System.out.print("Enter Task ID to Update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    boolean updated = false;

                    for (Task task : taskList) {
                        if (task.id == updateId) {
                            System.out.print("Enter New Title: ");
                            task.title = sc.nextLine();

                            System.out.print("Enter New Description: ");
                            task.description = sc.nextLine();

                            System.out.print("Enter New Status: ");
                            task.status = sc.nextLine();

                            updated = true;
                            System.out.println("✔ Task Updated Successfully");
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("❌ Task ID Not Found");
                    }
                    break;

                case 4: // DELETE
                    System.out.print("Enter Task ID to Delete: ");
                    int deleteId = sc.nextInt();

                    boolean deleted = false;

                    for (int i = 0; i < taskList.size(); i++) {
                        if (taskList.get(i).id == deleteId) {
                            taskList.remove(i);
                            deleted = true;
                            System.out.println("✔ Task Deleted Successfully");
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("❌ Task ID Not Found");
                    }
                    break;

                case 0:
                    System.out.println("Exiting Application...");
                    return;

                default:
                    System.out.println("❌ Invalid Choice");
            }

        } while (choice != 0);

        sc.close();
    }
}

class Task {
    int id;
    String title;
    String description;
    String status;
}
