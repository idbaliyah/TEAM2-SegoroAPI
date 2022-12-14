package org.example.sarah;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

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
