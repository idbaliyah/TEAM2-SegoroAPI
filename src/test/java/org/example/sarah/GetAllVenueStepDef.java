package org.example.sarah;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import java.io.File;

public class GetAllVenueStepDef {
    @Steps
    SegoroAPI segoroAPI;
//    @Given("Get venue with parameter user {int}")
//    public void getVenueWithParameterUserId(int id) {
//        segoroAPI.getAllVenue(id);
//    }
//
//    @When("Send get all venue request")
//    public void sendGetAllVenueRequest() {
//        SerenityRest.when().get(SegoroAPI.SET_ALL_VENUES);
//    }
//
//    @And("Response body page user {int}")
//    public void responseBodyPageUserId(int id) {
//        SerenityRest.then().body(SegoroResponses.DATA_VENUE_USER_ID,equalTo(id));
//    }
//
//    @And("Validate all venues json schema")
//    public void validateAllVenuesJsonSchema() {
//        File json = new File(SegoroAPI.JSON_SCHEMA+"/GetVenueByIDSchema.json");
//        SerenityRest.then()
//                .assertThat()
//                .body(JsonSchemaValidator.matchesJsonSchema(json));
//    }

    @Given("Get All venue valid parameter")
    public void getAllVenueValidParameter() {
        segoroAPI.getAllVenue();
    }

    @When("Send get all venue request")
    public void sendGetAllVenueToOwnerRequest() {
        SerenityRest.when().get(SegoroAPI.SET_ALL_VENUES);
    }

    @And("Validate get all venue json schema validator")
    public void validateGetAllVenueJsonSchemaValidator() {
        File json = new File(SegoroAPI.JSON_SCHEMA+"/GetVenueByIDSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
