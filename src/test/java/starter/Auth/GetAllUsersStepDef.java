package starter.Auth;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.io.File;


public class GetAllUsersStepDef {
    @Steps
    SegoroAPI segoroAPI;

    @Given("Get all users with valid parameter")
    public void getAllUsersWithValidParameter() {
        segoroAPI.getAllUsers();
    }

    @When("Send get all users request")
    public void sendGetAllUsersRequest() {
        SerenityRest.when().get(SegoroAPI.GET_ALL_USERS);
    }

    @And("Validate get all users json schema validator")
    public void validateGetAllUsersJsonSchemaValidator() {
        File json = new File(SegoroAPI.JSON_SCHEMA+"/GetAllUsers.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

}
