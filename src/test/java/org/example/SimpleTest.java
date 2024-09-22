package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.example.api.StudentRequests;
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
        // BDD: Given - When - Then
        StudentRequests.createStudent("{\n" +
                "  \"name\": \"Test\",\n" +
                "  \"grade\": 2\n" +
                "}");
    }

    @Test
    public void userShouldBeAbleDeleteExistingStudent() {
        // Step 1 - Create user

       String id = StudentRequests.createStudent("{\n" +
                "  \"name\": \"Test\",\n" +
                "  \"grade\": 2\n" +
                "}");

        // Step2 - Delete user
        StudentRequests.deleteStudent(id);

        // Verify that user don't exist
     StudentRequests.getStudent(id);
    }
}
