package org.example.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.example.model.Store;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

public class HomeTaskApiTest {

    @BeforeClass
    public void prepare() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("my.properties"));
        RestAssured.requestSpecification = (RequestSpecification) new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/")
                .addHeader("api_key", System.getProperty("api.key"))
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
        RestAssured.filters(new ResponseLoggingFilter());
    }

    @Test
    public void checkObjectSave() {
        Store store = new Store();
        int id = new Random().nextInt(500000);
        int petId = new Random().nextInt(20000);
        int quantity = new Random().nextInt(50);
        store.setId(id);
        store.setPetId(petId);
        store.setQuantity(quantity);
        store.setShipDate("2021-05-20T11:28:29.632Z");
        store.setStatus("placed");
        store.setComplete(true);

        given().
                body(store)
                .when()
                .post("store/order")
                .then()
                .statusCode(200);

        Store actual =
                given()
                        .pathParam("petId", id)
                        .when()
                        .get("/store/order/{petId}")
                        .then()
                        .statusCode(200)
                        .extract().body()
                        .as(Store.class);
        Assert.assertEquals(actual.getPetId(), store.getPetId());


        given()
                .pathParam("petId", id)
                .when()
                .delete("/store/order/{petId}")
                .then()
                .statusCode(200);
        given()
                .pathParam("petId", id)
                .when()
                .get("/store/order/{petId}")
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
        Assert.assertTrue(map.containsKey("sold"), "Inventory не содержит статус sold" );
    }
}
