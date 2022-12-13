package org.example.sarah;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class PutUpdateUserStepDef {
    @Steps
    SegoroAPI segoroAPI;

    @Given("Put update user with valid data")
    public void putUpdateUserWithValidData() {
        segoroAPI.putUser();
    }

    @When("Send put user request")
    public void sendPutUserRequest() {
        SerenityRest.when().put(SegoroAPI.UPDATE_USER);
    }

    @And("Put update photo profile user with multipart")
    public void putUpdatePhotoProfileUserWithMultipart() {
    }
}
