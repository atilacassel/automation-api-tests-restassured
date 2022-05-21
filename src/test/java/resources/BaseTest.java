package resources;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class BaseTest {
    protected final static  String PATH_BASE = "http://localhost:3000/";
    protected final static  String PATH_USERS = PATH_BASE + "Usuários/";
    protected final static  String PATH_PRODUCTS = PATH_BASE + "Produtos/";
    protected final static  String PATH_CARTS = PATH_BASE + "Carrinhos/";

    protected RequestSpecification prepareRequestWithBody(String requestBody) {
        return given().contentType(JSON).body(requestBody).when();
    }

    protected RequestSpecification prepareRequest() {
        return given().contentType(JSON).when();
    }

}
