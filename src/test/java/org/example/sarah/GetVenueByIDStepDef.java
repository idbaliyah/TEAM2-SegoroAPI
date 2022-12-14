package org.example.sarah;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class GetVenueByIDStepDef {
    @Steps
    SegoroAPI segoroAPI;

    //Get Single Venue By valid ID
    @Given("Get single venue with parameter venue {int}")
    public void getSingleVenueWithParameterVenueId(int id) {
        segoroAPI.getSingleVenue(id);
    }

    @When("Send get single venue request")
    public void sendGetSingleVenueRequest() {
        SerenityRest.when().get(SegoroAPI.SET_SINGLE_VENUE);
    }

    @And("Response body page venue be {int}")
    public void responseBodyPageVenueBeId(int id) {
        SerenityRest.then().body(SegoroResponses.DATA_VENUE_ID,equalTo(id));
    }

    @And("Validate single venue json schema")
    public void validateSingleVenueJsonSchema() {
        File json = new File(SegoroAPI.JSON_SCHEMA+"/GetVenueByIDSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
