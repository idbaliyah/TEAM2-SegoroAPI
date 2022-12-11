package starter.Auth;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostCreateUserStepDef {
    @Steps
    SegoroAPI segoroAPI;

    @Given("Post create user with valid data")
    public void postCreateUserWithValidJson() {
        segoroAPI.createUser();
    }

    @When("Send post user request")
    public void sendPostUserRequest() {
        SerenityRest.when().post(SegoroAPI.CREATE_USER);
    }
}
