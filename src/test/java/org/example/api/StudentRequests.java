package org.example.api;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class StudentRequests {
    public static String createStudent(String body) {
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/student")
                .then()
                .assertThat()
                .statusCode(201)
                .body("$", hasKey("_id"))
                .extract()
                .path("_id");
    }

    public static void deleteStudent(String id) {
        given()
                .delete("/student/" + id)
        .then()
                .assertThat()
                .statusCode(200);
    }
    public static void getStudent(String id) {
        given()
                .get("/student/" + id)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
