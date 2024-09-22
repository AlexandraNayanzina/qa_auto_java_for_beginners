package org.example.advanced.student;

public class Student {
    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public Student() {
        this.name = "undefined";
        this.id = 0;
    }

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Student(String name) {
        this.name = name;
        this.id = 0;
    }

    public Student(int id) {
        this.name = "undefined";
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
        this.id = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
