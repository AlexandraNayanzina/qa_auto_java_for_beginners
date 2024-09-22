package org.example.advanced.student;

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

    public void removeStudentAnotherMethod(int id) {

        Student targetStudent = null;

        for (Student student : students) {
            if (student.getId() == id) {
                targetStudent = student;
            }
        }
        if (targetStudent!= null) {
            students.remove(targetStudent);
        }  else {
            System.out.println("Student with id: " + id + "is not found");
        }
    }

    public static void main(String[] args) {

        StudentManager studentManager = new StudentManager();

        studentManager.addStudent(new Student("Alex", 1 ));
        studentManager.addStudent(new Student("Vasya", 2 ));
        studentManager.addStudent(new Student("Ivan", 3 ));
        studentManager.addStudent(new Student("Sweta", 4 ));
        studentManager.addStudent(new Student(5 ));
        studentManager.addStudent(new Student("Maxim" ));

//         Print out all the students
//        studentManager.getStudents().forEach(student -> System.out.println(student));

//        studentManager.removeStudent(1);
//        studentManager.getStudents().forEach(student -> System.out.println(student));

//        Remove Student with id=2
        studentManager.removeStudentAnotherMethod(2);
        System.out.println("Remained students after removing Student id=2");
        studentManager.getStudents().forEach(student -> System.out.println(student));

    }
}
