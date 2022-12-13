package org.example.sarah;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import java.io.File;

public class GetAllUserRequestStepDef {
    @Steps
    SegoroAPI segoroAPI;
    @Given("Get All users valid parameter")
    public void getAllUsersValidParameter() {
        segoroAPI.getAllUserRequest();
    }

    @When("Send get all users to owner request")
    public void sendGetAllUsersToOwnerRequest() {
        SerenityRest.when().get(SegoroAPI. SET_ALL_USER_REQ);
    }

    @And("Validate get all users request json schema validator")
    public void validateGetAllUsersRequestJsonSchemaValidator() {
        File json = new File(SegoroAPI.JSON_SCHEMA+"/GetAllUsersRequest.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
