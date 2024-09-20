package org.example.advanced.student;

import org.example.advanced.student.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        students.add(student);
    }

    public boolean removeStudent(int id){
        return students.removeIf(student -> student.getId() == id);
    }

    public List<Student> getStudents() {
        return students;
    }

    public static void main(String[] args) {

        StudentManager studentManager = new StudentManager();

        studentManager.addStudent(new Student("Alex", 1 ));
        studentManager.addStudent(new Student("Vasya", 2 ));
        studentManager.addStudent(new Student("Ivan", 3 ));

        studentManager.getStudents().forEach(student -> System.out.println(student));

        studentManager.removeStudent(1);

        studentManager.getStudents().forEach(student -> System.out.println(student));

    }
}
