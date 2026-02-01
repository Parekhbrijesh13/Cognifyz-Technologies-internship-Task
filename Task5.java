/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

import java.io.*;
import java.util.*;

public class Task5 {

    static final String FILE_NAME = "tasks.txt";
    static List<Task> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadTasksFromFile();

        while (true) {
            System.out.println("\n--- Task Manager ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1: addTask(); break;
                case 2: viewTasks(); break;
                case 3: updateTask(); break;
                case 4: deleteTask(); break;
                case 5:
                    saveTasksToFile();
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ---------------- FILE I/O ----------------

    static void loadTasksFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                String status = parts[2];
                tasks.add(new Task(id, title, status));
            }
            System.out.println("Tasks loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No existing file found. Starting fresh.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }

    static void saveTasksToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task t : tasks) {
                bw.write(t.toFileString());
                bw.newLine();
            }
            System.out.println("Tasks saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    // ---------------- CRUD ----------------

    static void addTask() {
        System.out.print("Enter task title: ");
        String title = sc.nextLine();
        int id = tasks.size() + 1;

        Task task = new Task(id, title, "Pending");
        tasks.add(task);
        saveTasksToFile();
        System.out.println("Task added.");
    }

    static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (Task t : tasks) {
            System.out.println(t);
        }
    }

    static void updateTask() {
        System.out.print("Enter task ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Task t : tasks) {
            if (t.id == id) {
                System.out.print("Enter new title: ");
                t.title = sc.nextLine();
                System.out.print("Enter new status (Pending/Completed): ");
                t.status = sc.nextLine();
                saveTasksToFile();
                System.out.println("Task updated.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    static void deleteTask() {
        System.out.print("Enter task ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        Iterator<Task> itr = tasks.iterator();
        while (itr.hasNext()) {
            Task t = itr.next();
            if (t.id == id) {
                itr.remove();
                saveTasksToFile();
                System.out.println("Task deleted.");
                return;
            }
        }
        System.out.println("Task not found.");
    }
}

// ---------------- TASK CLASS ----------------

class Task {
    int id;
    String title;
    String status;

    public Task(int id, String title, String status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }

    public String toFileString() {
        return id + "|" + title + "|" + status;
    }

    @Override
    public String toString() {
        return id + " - " + title + " [" + status + "]";
    }
}
