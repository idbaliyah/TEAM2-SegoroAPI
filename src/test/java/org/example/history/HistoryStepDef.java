package org.example.history;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.example.hooks.SegoroAPI;

import java.io.File;

public class HistoryStepDef {
    @Steps
    History history;
    @Given("get history valid id {int}")
    public void getHistoryValidId(int id) {
        history.getHistoryId(id);
    }

    @When("send get history id request")
    public void sendGetHistoryIdRequest() {
        SerenityRest.when().get(History.GET_HISTORY);
    }

    @And("validate get history id json schema validator")
    public void validateGetHistoryIdJsonSchemaValidator() {
        File json = new File(SegoroAPI.JSON_SCHEMA + "/History/HistorySchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("get history invalid id {int}")
    public void getHistoryInvalidId(int id) {
        history.getHistoryInvalidId(id);
    }

    @And("validate get history invalid id json schema validator")
    public void validateGetHistoryInvalidIdJsonSchemaValidator() {
        File json = new File(SegoroAPI.JSON_SCHEMA + "/History/HistoryInvalidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
