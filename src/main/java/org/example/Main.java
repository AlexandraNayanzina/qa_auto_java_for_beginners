package org.example;

import org.example.book.Book;
import org.example.clock.Clock;
import org.example.student.Student;
import org.example.task1.BankAccount;
import org.example.point.Point;
import org.example.car.Car;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("-----------\n");
        System.out.println("Example - BankAccount");
        BankAccount account1 = new BankAccount();
        account1.setBalance(10000);
        account1.print();

        System.out.println("-----------\n");
        System.out.println("Task - Book");

        Book book = new Book();
        book.setTitle("Testing Web APIs");
        book.setAuthor("Mark Winteringham");
        book.setYear(2022);
        book.display();

        System.out.println("-----------\n");
        System.out.println("Task - Student");

        Student student = new Student();
        student.setStudentName("Alex");
        student.setRecordBookNum(12345);
        student.setAvgScore(5);
        student.print();
        Student student1 = new Student("Vasya", 56789, 4);

        System.out.println("-----------\n");
        System.out.println("Task - Point");

        Point point1 = new Point(2,5);
        point1.moveUp();
        point1.moveDown();
        point1.moveLeft();
        point1.moveRight();

        System.out.println("-----------\n");
        System.out.println("Task - Clock");

        Clock clock = new Clock(4, 59, 59);
        clock.tick();
        clock.readTime();

        System.out.println("-----------\n");
        System.out.println("Task - Car");

        Car car1 = new Car("Nissan", "N1234567", 2000);
        car1.printCar();
        car1.start();
        car1.stop();
        car1.drive(10);

    }

}