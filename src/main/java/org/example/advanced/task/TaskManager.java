package org.example.advanced.task;


import  java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;


public class TaskManager {

    private ArrayList<Task> taskList;

    public TaskManager() {
        taskList = new ArrayList<>();
    }

    public void addTask(Task newTask) {
        taskList.add(newTask);
    }

    public void displayTasks() {
        System.out.println("Task list: ");
        for (Task task : taskList) {
            System.out.println(task);
        }
    }

    public void removeTask(String description) {
        boolean taskRemoved = false;
        for (Task task : taskList) {
            if (task.getDescription().equals(description)) {
                taskList.remove(task);
                System.out.println("Removed task: " + task);
                taskRemoved = true;
                break;
            }
        }
        if (!taskRemoved) {
            System.out.println("Task with the description: " + description + "was not found");
        }
    }

    // Sort method by priority (1 - is the highest priority; 3 - is the lowest)
    public void sortTasksByPriority() {
        Collections.sort(taskList, new Comparator<>() {
            @Override
            public int compare(Task t1, Task t2) {
                return Integer.compare(t1.getPriority(), t2.getPriority());
            }
        });
        System.out.println("Tasks sorted by priority: ");
    }

    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();

        //Create tasks
        Task task1 = new Task("Finish homework", 1);
        Task task2 = new Task("Pay the bills", 2);
        Task task3 = new Task("Buy milk", 1);
        Task task4 = new Task("Walk with the dog", 2);
        Task task5 = new Task("Send the email", 3);
        Task task6 = new Task("Answer to the Manager", 1);
        Task task7 = new Task("Cook the dinner", 2);
        Task task8 = new Task("Go to the gym", 3);


        //Add tasks
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);
        taskManager.addTask(task4);
        taskManager.addTask(task5);
        taskManager.addTask(task6);
        taskManager.addTask(task7);
        taskManager.addTask(task8);

        taskManager.removeTask("cfnfn");
        taskManager.removeTask("Cook the dinner");

        // Unsorted tasks
        taskManager.displayTasks();

        //Sorted
        taskManager.sortTasksByPriority();
        taskManager.displayTasks();

    }
}
