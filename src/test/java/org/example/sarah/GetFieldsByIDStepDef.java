package org.example.sarah;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import java.io.File;

public class GetFieldsByIDStepDef {
    @Steps
    SegoroAPI segoroAPI;

    @Given("Get single field with valid {int}")
    public void getSingleFieldWithValidId(int id) {
        segoroAPI.getSingleField(id);
    }

    @When("Send get single field request")
    public void sendGetSingleFieldRequest() {
        SerenityRest.when().get(SegoroAPI.GET_SINGLE_FIELD);
    }

    @And("Validate get single field json schema")
    public void validateGetSingleFieldJsonSchema() {
        File json = new File(SegoroAPI.JSON_SCHEMA+"/GetFieldsByIDSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
