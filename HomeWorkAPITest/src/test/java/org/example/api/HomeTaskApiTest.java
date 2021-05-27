package org.example.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.example.model.Store;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

public class HomeTaskApiTest {
    private int id;
    private Store store;
    private int petId;
    private int quantity;

    @BeforeMethod
    public void prepare() throws IOException {
        store = new Store();
        id = new Random().nextInt(500000);
        petId = new Random().nextInt(2000);
        quantity = new Random().nextInt(50);
        store.setId(id);
        store.setPetId(petId);
        store.setQuantity(quantity);
        store.setShipDate("2021-05-20T11:28:29.632+0000");
        store.setStatus("placed");
        store.setComplete(true);

        System.getProperties().load(ClassLoader.getSystemResourceAsStream("my.properties"));
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/")
                .addHeader("api_key", System.getProperty("api.key"))
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
        RestAssured.filters(new ResponseLoggingFilter());

        given().
                body(store)
                .when()
                .post("store/order")
                .then()
                .statusCode(200)
                .body(
                        "id", equalTo(store.getId()),
                        "petId", equalTo(store.getPetId()),
                        "quantity", equalTo(store.getQuantity()),
                        "shipDate", equalTo(store.getShipDate()),
                        "status", equalTo(store.getStatus()),
                        "complete", equalTo(store.isComplete())
                );
    }

    @Test
    public void checkObjectGet() {
        Store actual =
                given()
                        .pathParam("id", store.getId())
                        .when()
                        .get("/store/order/{id}")
                        .then()
                        .statusCode(200)
                        .body(
                                "id", equalTo(store.getId()),
                                "petId", equalTo(store.getPetId()),
                                "quantity", equalTo(store.getQuantity()),
                                "shipDate", equalTo(store.getShipDate()),
                                "status", equalTo(store.getStatus()),
                                "complete", equalTo(store.isComplete())
                        )
                        .extract().body()
                        .as(Store.class);
        Assert.assertEquals(actual.getId(), store.getId());
    }

    @Test
    public void checkObjectDelete() {
        given()
                .pathParam("id", store.getId())
                .when()
                .delete("/store/order/{id}")
                .then()
                .statusCode(200);
    }

    @Test
    public void checkObjectGetError() {
        given()
                .pathParam("id", store.getId())
                .when()
                .delete("/store/order/{id}")
                .then()
                .statusCode(200);

        given()
                .pathParam("id", store.getId())
                .when()
                .get("/store/order/{id}")
                .then()
                .statusCode(404);
    }

    @Test
    public void inventory() {
        Map map =
                given()
                        .when()
                        .get("/store/inventory")
                        .then()
                        .statusCode(200)
                        .extract()
                        .body()
                        .as(Map.class);
        Assert.assertTrue(map.containsKey("sold"), "Inventory не содержит статус sold");

        Assert.assertTrue(map.get("sold") instanceof Double);
        Assert.assertTrue(map.get("pending") instanceof Double);
        Assert.assertTrue(map.get("Available") instanceof Double);
        Assert.assertTrue(map.get("available") instanceof Double);
        Assert.assertTrue(map.get("string") instanceof Double);
    }
}
