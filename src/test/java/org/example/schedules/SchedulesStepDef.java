package org.example.schedules;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.example.Response;
import org.example.hooks.SegoroAPI;
import org.example.schedules.Schedules;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class SchedulesStepDef {

    @Steps
    Schedules schedules;

    @Given("create new schedules with body")
    public void createNewSchedulesWithBody() {
        File json = new File(SegoroAPI.JSON_REQ_BODY + "/CreateSchedules.json");
        schedules.postScheduleFieldId(json);
    }

    @When("send post create schedules request")
    public void sendPostCreateSchedulesRequest() {
        SerenityRest.when().post(Schedules.POST_SCHEDULE_FIELD_ID);
    }

    @Then("status code is {int} OK")
    public void statusCodeIsOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("response body should status {string}")
    public void responseBodyShouldStatus(String status) {
        SerenityRest.then()
                .body(Response.STATUS, equalTo(status));
    }

    @And("validate create schedule json schema validator")
    public void validateCreateScheduleJsonSchemaValidator() {
        File json = new File(SegoroAPI.JSON_SCHEMA+"/Schedules/CreateSchedulesSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("get all schedules")
    public void getAllSchedules() {
        schedules.getAllSchedules();
    }

    @When("send all schedules request")
    public void sendAllSchedulesRequest() {
        SerenityRest.when().get(Schedules.GET_ALL_SCHEDULES);
    }

    @And("validate get all schedules json schema validator")
    public void validateGetAllSchedulesJsonSchemaValidator() {
        File json = new File(SegoroAPI.JSON_SCHEMA + "/Schedules/AllSchedulesSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("get schedules invalid id {int}")
    public void getSchedulesInvalidId(int id) {
        schedules.getScheduleInvalidId(id);
    }

    @When("send get schedules request")
    public void sendGetSchedulesRequest() {
        SerenityRest.when().get(Schedules.GET_SCHEDULE_PARAM);
    }

    @Given("get schedule valid id {int}")
    public void getScheduleValidId(int id) {
        schedules.getScheduleValidId(id);
    }

    @When("send get schedule request")
    public void sendGetScheduleRequest() {
        SerenityRest.when().get(Schedules.GET_SCHEDULE_PARAM);
    }

    @And("validate get schedules id json schema validator")
    public void validateGetSchedulesIdJsonSchemaValidator() {
        File json = new File(SegoroAPI.JSON_SCHEMA + "/Schedules/SchedulesIdSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("get schedule field id {int}")
    public void getScheduleFieldId(int id) {
        schedules.getScheduleFieldId(id);
    }

    @Given("get schedule invalid field id {int}")
    public void getScheduleInvalidFieldId(int id) {
        schedules.getScheduleInvalidFieldId(id);
    }

    @And("validate get schedules field id json schema validator")
    public void validateGetSchedulesFieldIdJsonSchemaValidator() {
        File json = new File(SegoroAPI.JSON_SCHEMA + "/Schedules/SchedulesFieldIdSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("update schedule id {int}")
    public void updateScheduleId(int id) {
        File json = new File(SegoroAPI.JSON_REQ_BODY + "/EditSchedules.json");
        schedules.putScheduleId(id, json);
    }

    @When("send update schedule request")
    public void sendUpdateScheduleRequest() {
        SerenityRest.when().put(Schedules.PUT_SCHEDULE_PARAM);
    }

    @And("validate update schedule id json schema validator")
    public void validateUpdateScheduleIdJsonSchemaValidator() {
        File json = new File(SegoroAPI.JSON_SCHEMA + "/Schedules/UpdateSchedulesIdSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("delete schedule invalid id {int}")
    public void deleteScheduleInvalidId(int id) {
        schedules.deleteScheduleInvalidId(id);
    }

    @When("send delete schedule request")
    public void sendDeleteScheduleRequest() {
        SerenityRest.when().delete(Schedules.DELETE_SCHEDULE_PARAM);
    }

    @Given("delete schedule valid id {int}")
    public void deleteScheduleValidId(int id) {
        schedules.deleteScheduleId(id);
    }

    @And("validate delete schedule id json schema validator")
    public void validateDeleteScheduleIdJsonSchemaValidator() {
        File json = new File(SegoroAPI.JSON_SCHEMA + "/Schedules/DeleteSchedulesIdSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
