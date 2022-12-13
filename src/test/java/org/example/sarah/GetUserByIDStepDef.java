package org.example.sarah;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetUserByIDStepDef {
    @Steps
    SegoroAPI segoroAPI;
    @Given("Get single user with parameter user {int}")
    public void getSingleUserWithParameterUserId(int id) {
        segoroAPI.getSingleUsers(id);
    }

    @When("Send get single user request")
    public void sendGetSingleUserRequest() {
        SerenityRest.when().get(SegoroAPI.SET_SINGLE_USER);
    }

    @And("Response body page user be {int}")
    public void responseBodyPageUserBeId(int id) {
        SerenityRest.then().body(SegoroResponses.DATA_ID,equalTo(id));
    }

    @And("Response body page user user be {int}")
    public void responseBodyPageUserBeId2(int id) {
        SerenityRest.then().body(SegoroResponses.DATA_ID2,equalTo(id));
    }

    @And("Validate user by id with json schema")
    public void validateUserByIdWithJsonSchema() {
        File json = new File(SegoroAPI.JSON_SCHEMA + "/GetUserBYIDSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
