package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.example.api.StudentRequests;
import org.example.api.models.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class SimpleTest {
    @BeforeAll
    public static void setupTests(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/dc5201f0cf314b16b81218f86a523e2b";
    }

    @Test
    public void userShouldBeAbleCreateStudent() {
        Student student = new Student("Alex Test", 2);
        StudentRequests.createStudent(student);
    }

    @Test
    public void userShouldBeAbleDeleteExistingStudent() {
        // Serialization and deserialization
        Student student = new Student("Alex Test", 2);

        // Step 1 - Create user
       Student createdStudent = StudentRequests.createStudent(student);

        // Step2 - Delete user
        StudentRequests.deleteStudent(createdStudent.getId());

        // Verify that user don't exist
        StudentRequests.getRemovedStudent(createdStudent.getId());
    }
}
