package org.example.api;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class UnicornRequests {

    public static String createUnicorn(String body) {
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/unicorn")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body("$",hasKey("_id"))
                .extract()
                .path("_id");
    }

    public static void deleteUnicorn(String id) {
        given()
                .when()
                .delete("/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(200);
    }

    public static void getUnicorn(String id) {
        given()
                .delete("/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(404);
    }
}
