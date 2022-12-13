package org.example.sarah;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import java.io.File;

public class GetAllDataFieldsStepDef {
    @Steps
    SegoroAPI segoroAPI;
    @Given("Get all data field with valid parameter")
    public void getAllDataFieldWithValidParameter() {
        segoroAPI.getAllDataFields();
    }

    @When("Send all data field request")
    public void sendAllDataFieldRequest() {
        SerenityRest.when().get(SegoroAPI.GET_ALL_FIELDS);
    }

    @And("Validate all data fields json schema validator")
    public void validateAllDataFieldsJsonSchemaValidator() {
        File json = new File(SegoroAPI.JSON_SCHEMA+"/GetAllFieldsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
