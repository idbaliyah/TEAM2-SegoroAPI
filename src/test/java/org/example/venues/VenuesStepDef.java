package org.example.venues;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.example.Response;
import org.example.hooks.SegoroAPI;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class VenuesStepDef {

    @Steps
    Venues venues;

    @Given("create new venues with body")
    public void createNewVenuesWithBody() {
        File json = new File(SegoroAPI.JSON_REQ_BODY + "/CreateVenues.json");
        venues.postCreateNewVenue(json);
    }

    @When("send post create venues request")
    public void sendPostCreateVenuesRequest() {
        SerenityRest.when()
                .post(Venues.POST_CREATE_NEW_VENUES);
    }

    @Then("status code is {int} OK")
    public void statusCodeIs(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("response body should status {string}")
    public void responseBodyShouldStatus(String status) {
        SerenityRest.then()
                .body(Response.STATUS, equalTo(status));
    }

    @And("validate create venue json schema validator")
    public void validateCreateVenueJsonSchemaValidator() {
        File json = new File(SegoroAPI.JSON_SCHEMA + "/Venues/CreateNewVenueSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("delete venues valid id {int}")
    public void deleteVenuesValidId(int id) {
        venues.deleteVenuesValidId(id);
    }

    @When("send delete venues request")
    public void sendDeleteVenuesRequest() {
        SerenityRest.when().delete(Venues.DELETE_VENUES_PARAM);
    }



    @And("validate delete venue json schema validator")
    public void validateDeleteVenueJsonSchemaValidator() {
        File json = new File(SegoroAPI.JSON_SCHEMA + "/Venues/DeleteVenueSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}

