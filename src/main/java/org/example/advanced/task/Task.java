package org.example.advanced.task;

public class Task {
    private String description;
    private int priority;

    public Task(String description, int priority) {
        this.priority = priority;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
