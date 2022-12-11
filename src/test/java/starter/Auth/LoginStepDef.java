package starter.Auth;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;


public class LoginStepDef {
    @Steps
    SegoroAPI segoroAPI;

    //OWNER - LOGIN WITH VALID ID
    @Given("Post login user owner with valid json")
    public void postLoginUserWithValidJsonOwner() {
        File json = new File(SegoroAPI.JSON_REQ_BODY + "/PostLoginOwner.json");
        segoroAPI.loginUser(json);
    }

    @When("Send post login user request")
    public void sendPostLoginUserRequest() {
        SerenityRest.when().post(SegoroAPI.LOGIN_USER);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Response body should contain {string} as role")
    public void responseBodyShouldContainAsTokenOwner(String role) {
        SerenityRest.then().body(SegoroResponses.ROLE, equalTo(role));
//        throw new io.cucumber.java.PendingException();
    }

    @And("Validate login with json schema")
    public void validateLoginWithJsonSchema() {
        File json = new File(SegoroAPI.JSON_SCHEMA + "/LoginSuccessSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //USER - LOGIN WITH VALID ID
    @Given("Post login user with valid json")
    public void postLoginUserWithValidJson() {
        File json = new File(SegoroAPI.JSON_REQ_BODY + "/PostLoginUser.json");
        segoroAPI.loginUser(json);
    }

    //ADMIN - LOGIN WITH VALID ID
    @Given("Post login admin with valid json")
    public void postLoginAdminWithValidJson() {
        File json = new File(SegoroAPI.JSON_REQ_BODY + "/PostLoginAdmin.json");
        segoroAPI.loginUser(json);
    }
}
