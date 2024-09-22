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

    @Test
    public void userShouldBeAbleToCreateUnicorn() {
        Unicorn unicorn1 = new Unicorn("Unic2", "purple");
        UnicornRequests.createUnicorn(unicorn1);
    }

    @Test
    public void userShouldBeAbleToDeleteUnicorn() {
        Unicorn unicorn = new Unicorn("Unic3", "purple");
        Unicorn createdIUnicorn = UnicornRequests.createUnicorn(unicorn);

        //Delete the Unicorn by id
        UnicornRequests.deleteUnicorn(createdIUnicorn.getId());

        //Verify that Unicorn does not exist
        UnicornRequests.getRemovedUnicorn(createdIUnicorn.getId());
    }

    @Test
    public void userShouldBeAbleToUpdateUnicorn() {
        String newColor = "yellow";
        Unicorn unicorn = new Unicorn("Unic2", newColor);

        // Create a Unicorn
        Unicorn createdUnicorn = UnicornRequests.createUnicorn(unicorn);
        //Update color
        UnicornRequests.updateColor(createdUnicorn.getId(), "{\n" +
                "  \"name\": \"Unic\",\n" +
                "  \"color\": \"yellow\"\n" +
                "}");

        //Verify that Unicorn has new color
        String color = UnicornRequests.getUnicorn(createdUnicorn.getId(), newColor);


    }

}
