package org.example.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.apache.http.HttpStatus;
import org.example.api.models.Unicorn;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class UnicornRequests {

    public static Unicorn createUnicorn(Unicorn unicorn) {
        String unicornJson = null;
        try {
            unicornJson = new ObjectMapper().writeValueAsString(unicorn);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return given()
                .contentType(ContentType.JSON)
                .body(unicornJson)
                .when()
                .post("/unicorn")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body("$", hasKey("_id"))
                .extract().as(Unicorn.class, ObjectMapperType.GSON);
    }


    public static void deleteUnicorn(String id) {
        given()
                .when()
                .delete("/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(200);
    }

    public static void getRemovedUnicorn(String id) {
        given()
                .delete("/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(404);
    }
    public static void updateColor(String id, String body) {
        given()
                .contentType(ContentType.JSON)
                .body(body)
                .put("/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(200);
    }

    public static String getUnicorn(String id, String color) {
        given()
                .when()
                .get("/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(200)
                .body("color", equalTo(color));
        return id;
    }
}



