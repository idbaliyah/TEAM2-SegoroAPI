package org.example.sarah;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class GetReviewByVenueIDStepDef {
    @Steps
    SegoroAPI segoroAPI;

    @Given("Get review with Venue {int}")
    public void getReviewWithVenueId(int id) {
        segoroAPI.getReviewByVenueID(id);
    }

    @When("Send get review request")
    public void sendGetReviewRequest() {
        SerenityRest.when().get(SegoroAPI.GET_REVIEW_BY_VENUE_ID);
    }

    @And("Response body page review be {int}")
    public void responseBodyPageReviewBeId(int id) {
        SerenityRest.then().body(SegoroResponses.DATA_ID,equalTo(id));
    }

    @And("Validate review with json schema")
    public void validateReviewWithJsonSchema() {
        File json = new File(SegoroAPI.JSON_SCHEMA+"/GetReviewByVenueIDSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
