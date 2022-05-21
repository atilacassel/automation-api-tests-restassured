package core;

import io.restassured.http.ContentType;

public interface Constants {

    String APP_BASE_URL = "http://localhost:3000/";

    ContentType APP_CONTENT_TYPE = ContentType.JSON;

    Long MAX_TIMEOUT = 1000l;
}
