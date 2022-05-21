package tests;

import org.junit.Test;
import resources.BaseTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class UsersTest extends BaseTest {

    @Test
    public void returnsRegisteredUsers() {
        given()
                .when()
                .get("/usuarios")
                .then()
                .log().all()
                .statusCode(200)
                .body(is(not(nullValue())));
    }
}
