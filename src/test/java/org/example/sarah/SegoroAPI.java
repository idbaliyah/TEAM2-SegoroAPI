package org.example.sarah;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class SegoroAPI {
//    public static String URL = "https://app.swaggerhub.com/apis-docs/raorafarhan/segoro/1.0.0#";
//    public static String SET_SINGLE_USER = URL + "/api/users/{id}";
    public static String URL                = "https://altapro.online";
    public static final String DIR          = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR + "/src/test/resources/JSON/RequestBody";
    public static final String JSON_SCHEMA  = DIR + "/src/test/resources/JSON/JsonSchema";
    public static String LOGIN_USER         = URL + "/login";
    public static String SET_SINGLE_USER    = URL + "/users/{user_id}";
    public static String SET_SINGLE_VENUE   = URL + "/venues/{venue_id}";
    public static String SET_ALL_VENUES     = URL + "/venues";
    public static String SET_ALL_USER_REQ   = URL + "/users/request";
    public static String GET_ALL_USERS      = URL + "/users";
    public static String GET_REVIEW_BY_VENUE_ID = URL + "/reviews/{venue_id}";
    public static String GET_ALL_FIELDS     = URL + "/fields";
    public static String GET_SINGLE_FIELD   = URL + "/fields/{id}";
    public static String DELETE_USER        = URL + "/users";
    public static String CREATE_USER        = URL + "/users";
    public static String UPDATE_USER        = URL + "/users";
    public static String CREATE_REVIEW      = URL + "/reviews";
    public static String APPROVE_USER       = URL + "/users/adminapprove/{user_id}";
    public static String UPGRADE_USER       = URL + "/users/owner";
    public static String PHOTOS             = DIR + "/src/test/resources/Photo";
    public static final String BEARER_TOKEN_ADMIN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2NzA5OTY0NTgsImZvdG9fdXNlciI6IiIsIm5hbWVfdXNlciI6InRyeTR1c2VyIiwicm9sZSI6InVzZXIiLCJ1c2VySWQiOjQ0LCJ1c2VyX293bmVyIjpmYWxzZX0.vLL5bpBbjiJl1oL78HelByj2JoWwT9cVmXK6_sMgMpo";
    public static final String BEARER_TOKEN_OWNER = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2NzA5OTcyOTEsImZvdG9fdXNlciI6Imh0dHBzOi8vc3RvcmFnZS5nb29nbGVhcGlzLmNvbS9hbHRhYnVja2V0L3NlZ29yb2J1Y2tldC91c2Vycy9Vc2VyMV9waG90bzk3M2MzM2YxLWRiOGEtNGQyMy05MWNlLTViYmU5MTBmN2Q4Zi5wbmciLCJuYW1lX3VzZXIiOiJVc2VyMSIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0LCJ1c2VyX293bmVyIjp0cnVlfQ.80rjlA5pZGZdkxYSiuB3dvEz9gvhalUHS4jSTkr7SV8";
    public static final String BEARER_TOKEN_USER = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2NzA0MTE5MTYsImZvdG9fdXNlciI6Im51bGwiLCJuYW1lX3VzZXIiOiJpZGJhbGl5YWgiLCJyb2xlIjoidXNlciIsInVzZXJJZCI6MTAsInVzZXJfb3duZXIiOmZhbHNlfQ.x39_hnv1LJ7vWKSbG5eNsojIviTljiD022WE5r6Q8Y0";



    //LOGIN//
    @Step("Login user with valid id")
    public void loginUser(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Login invalid user")
    public void loginInvalidUser(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    //CREATE USER//
    @Step("Post create user")
    public void createUser(){
        SerenityRest.given()
                .headers("Content-type", "multipart/form-data")
                .multiPart("foto_user", new File(PHOTOS + "/User1.jpg"))
                .multiPart("name_user", "User11")
                .multiPart("email", "user11@mail.com")
                .multiPart("password", "123123")
                .multiPart("address_user", "Papua Utara");
    }

    //UPDATE USER//
    @Step("Post update user")
    public void putUser(){
        SerenityRest.given()
                .headers("Content-type", "multipart/form-data")
                .headers("Authorization", "Bearer "+BEARER_TOKEN_ADMIN)
                .multiPart("foto_owner", new File(PHOTOS + "/User1.jpg"))
                .multiPart("name_user", "User 4 Update")
                .multiPart("email", "user4update@mail.com")
                .multiPart("password", "123123")
                .multiPart("address_user", "Papua Utara");

    }

    //APPROVE USER//
    @Step("Put Approve User")
    public void approveUser(int id){
        SerenityRest.given().pathParam("user_id", id)
                .headers("Content-type", "multipart/form-data")
                .headers("Authorization", "Bearer "+BEARER_TOKEN_ADMIN);
    }

    //UPGRADE USER//
    @Step("Put Upgrade User")
    public void upgradeUser(){
        SerenityRest.given()
                .headers("Content-type", "multipart/form-data")
                .headers("Authorization", "Bearer "+BEARER_TOKEN_ADMIN)
                .multiPart("foto_owner", new File(PHOTOS + "/User1.jpg"));


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

    //CREATE REVIEW
    @Step("Post create review")
    public void createReview(){
        SerenityRest.given()
                .headers("Content-type", "multipart/form-data")
                .multiPart("foto_review", new File(PHOTOS + "/User1.jpg"))
                .multiPart("rate", "80")
                .multiPart("feedback", "bagus kok")
                .multiPart("venue_id", "1")
                .headers("Authorization", "Bearer "+BEARER_TOKEN_ADMIN);
    }

    //GET REVIEW BY VENUE ID//
    @Step("Get review by venue ID")
    public void getReviewByVenueID(int venue_id) {
        SerenityRest.given().pathParam("venue_id", venue_id)
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
                .headers("Authorization", "Bearer "+BEARER_TOKEN_OWNER);
    }

    //DELETE USER BY ID//
    @Step("Delete user by ID")
    public void deleteUser(int id){
        SerenityRest.given().queryParam("id", id)
                .headers("Authorization", "Bearer "+BEARER_TOKEN_ADMIN)
                .contentType(ContentType.JSON);
    }

}
