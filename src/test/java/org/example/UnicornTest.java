package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.example.api.UnicornRequests;
import org.example.api.models.Unicorn;
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

        Unicorn unicorn1 = new Unicorn("Unic2", "purple");
        String id = UnicornRequests.createUnicorn(unicorn1.toJson());
        //Delete the Unicorn by id
        UnicornRequests.deleteUnicorn(id);

        //Verify that Unicorn does not exist
        UnicornRequests.getRemovedUnicorn(id);
    }
    @Test
    public void userShouldBeAbleToUpdateUnicorn() {
        String newColor = "yellow";
        Unicorn unicorn1 = new Unicorn("Unic2", newColor);

        // Create a Unicorn
        String id = UnicornRequests.createUnicorn(unicorn1.toJson());
        //Update color
        UnicornRequests.updateColor(id, "{\n" +
                "  \"name\": \"Unic\",\n" +
                "  \"color\": \"yellow\"\n" +
                "}");

        //Verify that Unicorn has new color
        String color = UnicornRequests.getUnicorn(id, newColor);


    }

}
