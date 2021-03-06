package org.example.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.example.model.Pet;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import static io.restassured.RestAssured.given;

public class ApiTest {
    private Pet pet;
    private int id;
    private String name;

    @BeforeClass
    public void prepare() throws IOException {
        pet = new Pet();
        id = new Random().nextInt(500000);
        name = "Pet_" + UUID.randomUUID().toString();
        pet.setId(id);
        pet.setName(name);

        System.getProperties().load(ClassLoader.getSystemResourceAsStream("my.properties"));

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/")
                .addHeader("api_key", System.getProperty("api.key"))
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
        RestAssured.filters(new ResponseLoggingFilter());
    }

    @Test
    public void checkObjectSave() {

        given()
                .body(pet)
                .when()
                .post("/pet")
                .then()
                .statusCode(200);

        Pet actual =
                given()
                        .pathParam("petId", id)
                        .when()
                        .get("/pet/{petId}")
                        .then()
                        .statusCode(200)
                        .extract().body()
                        .as(Pet.class);

        Assert.assertEquals(actual.getName(), pet.getName());

    }

    @Test
    public void testDelete() throws IOException {
        given()
                .body(pet)
                .when()
                .post("/pet")
                .then()
                .statusCode(200);

        System.getProperties().load(ClassLoader.getSystemResourceAsStream("my.properties"));
        given()
                .pathParam("petId", id)
                .when()
                .delete("/pet/{petId}")
                .then()
                .statusCode(200);
        given()
                .pathParam("petId", id)
                .when()
                .get("/pet/{petId}")
                .then()
                .statusCode(404);
    }
}
