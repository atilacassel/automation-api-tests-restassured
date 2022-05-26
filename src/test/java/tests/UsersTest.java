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

    @Test
    public void registerUsersSuccessfully() {
        given()
                .body("{\n" +
                        "        \"nome\": \"Atila da Silva\",\n" +
                        "        \"email\": \"atila2@qa.com.br\",\n" +
                        "        \"password\": \"teste\",\n" +
                        "        \"administrador\": \"true\"\n" +
                        "        }")
                .when()
                .post("/usuarios")
                .then()
                .log().all()
                .statusCode(201)
                .body("message", is("Cadastro realizado com sucesso"));
    }

    @Test
    public void emailAlreadyRegistered() {
        given()
                .body("{\n" +
                        "        \"nome\": \"Atila da Silva\",\n" +
                        "        \"email\": \"atila2@qa.com.br\",\n" +
                        "        \"password\": \"teste\",\n" +
                        "        \"administrador\": \"true\"\n" +
                        "        }")
                .when()
                .post("/usuarios")
                .then()
                .log().all()
                .statusCode(400)
                .body("message", is("Este email já está sendo usado"));
    }
}

