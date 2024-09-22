package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.example.api.UnicornRequests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class UnicornTest {
    @BeforeAll
    public static void setupTests(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/dc5201f0cf314b16b81218f86a523e2b";
    }

    // Create a Unicorn, save the id
    @Test
    public void userShouldBeAbleToCreateUnicorn() {

        String id = UnicornRequests.createUnicorn("{\n" +
                "  \"name\": \"Unic\",\n" +
                "  \"color\": \"pink\"\n" +
                "}");

        //Delete the Unicorn by id
        UnicornRequests.deleteUnicorn(id);

        //Verify that Unicorn does not exist
        UnicornRequests.getUnicorn(id);
    }

}
