package starter.Auth;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class SegoroAPI {
//    public static String URL = "https://app.swaggerhub.com/apis-docs/raorafarhan/segoro/1.0.0#";
    public static String URL = "https://altaproject.online";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR + "/src/test/resources/JSON/RequestBody";
    public static final String JSON_SCHEMA = DIR + "/src/test/resources/JSON/JsonSchema";
    public static String LOGIN_USER = URL + "/login";
    public static String SET_SINGLE_USER = URL + "/users/{user_id}";
//    public static String SET_SINGLE_USER = URL + "/api/users/{id}";
    public static String SET_SINGLE_VENUE = URL + "/venues/{venue_id}";
    public static String SET_ALL_VENUES = URL + "/venues";
    public static String SET_ALL_USER_REQ   = URL + "/users/request";
    public static String GET_ALL_USERS = URL + "/users";
    public static String GET_REVIEW_BY_VENUE_ID = URL + "/reviews/{id}";
    public static String GET_ALL_FIELDS = URL + "/fields";
    public static String GET_SINGLE_FIELD = URL + "/fields/{id}";
    public static final String BEARER_TOKEN_ADMIN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2NzA0NjM1NjQsImZvdG9fdXNlciI6Imh0dHBzOi8vc3RvcmFnZS5nb29nbGVhcGlzLmNvbS9hbHRhYnVja2V0L3NlZ29yb2J1Y2tldC91c2Vycy9hZG1pbjFfcGhvdG83NzNjOTA5My0wNTExLTQxZjAtYjc5OS0yZTMxZjAzM2EyZWYucG5nIiwibmFtZV91c2VyIjoiYWRtaW4xIiwicm9sZSI6ImFkbWluIiwidXNlcklkIjoyMywidXNlcl9vd25lciI6ZmFsc2V9.ijDQOXWRMaOixrPl5yWgIxZdkZmSoAWdVkjpQpl7tKc";
    public static final String BEARER_TOKEN_OWNER = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2NzA0NjM1NjQsImZvdG9fdXNlciI6Imh0dHBzOi8vc3RvcmFnZS5nb29nbGVhcGlzLmNvbS9hbHRhYnVja2V0L3NlZ29yb2J1Y2tldC91c2Vycy9hZG1pbjFfcGhvdG83NzNjOTA5My0wNTExLTQxZjAtYjc5OS0yZTMxZjAzM2EyZWYucG5nIiwibmFtZV91c2VyIjoiYWRtaW4xIiwicm9sZSI6ImFkbWluIiwidXNlcklkIjoyMywidXNlcl9vd25lciI6ZmFsc2V9.ijDQOXWRMaOixrPl5yWgIxZdkZmSoAWdVkjpQpl7tKc";


    //LOGIN//
    @Step("Login user with valid id")
    public void loginUser(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Login invalid user")
    public void loginInvalidUser(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    //GET SINGLE USER//
    @Step("Get single users")
    public void getSingleUsers(int id) {
        SerenityRest.given().pathParam("user_id", id).headers("Authorization", "Bearer "+BEARER_TOKEN_ADMIN);
    }

    //GET ALL USERS//
    @Step("Get all request")
    public void getAllUsers() {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN_ADMIN);
    }

    //GET SINGLE VENUE//
    @Step("Get single venue")
    public void getSingleVenue(int id) {
        SerenityRest.given().pathParam("venue_id", id)
                .headers("Authorization", "Bearer "+BEARER_TOKEN_ADMIN);
    }

    //GET ALL VENUES BY USER ID//
    @Step("Get all venues")
    public void getAllVenue() {
        SerenityRest.given().headers("Authorization", "Bearer "+BEARER_TOKEN_ADMIN);
    }

    //GET ALL USER REQUEST TO BE OWNER//
    @Step("Get all request")
    public void getAllUserRequest() {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN_ADMIN);
    }

    //GET REVIEW BY VENUE ID//
    @Step("Get review by venue ID")
    public void getReviewByVenueID(int id) {
        SerenityRest.given().pathParam("venue_id", id)
                .headers("Authorization", "Bearer "+BEARER_TOKEN_ADMIN);
    }

    //GET ALL DATA FIELDS//
    @Step("Get all data fields")
    public void getAllDataFields() {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN_ADMIN);
    }

    //GET FIELD BY ID//
    @Step("Get field by ID")
    public void getSingleField(int id) {
        SerenityRest.given().pathParam("id", id)
                .headers("Authorization", "Bearer "+BEARER_TOKEN_ADMIN);
    }

}
