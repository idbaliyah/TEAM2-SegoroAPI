package org.example.venues;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.example.hooks.SegoroAPI;

import java.io.File;

import static org.example.hooks.SegoroAPI.TOKEN_OWNER;

public class Venues {

    public static String POST_CREATE_NEW_VENUES = SegoroAPI.URL + "/venues";

    public static String DELETE_VENUES_PARAM = SegoroAPI.URL + "/venues/{venues_id}";


    @Step("POST venues")
    public void postCreateNewVenue(File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN_OWNER)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("DELETE venues ID")
    public void deleteVenuesValidId(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_OWNER )
                .pathParam("venues_id", id);
    }



}
