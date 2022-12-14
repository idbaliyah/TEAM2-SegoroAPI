package org.example.sarah;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class UpdateUserToOwnerStepDef {
    @Steps
    SegoroAPI segoroAPI;

    @Given("Put approve user to be owner with valid {int}")
    public void putApproveUserToBeOwnerWithValidId(int id) {
        segoroAPI.approveUser(id);
    }

    @When("Send put approve user to be owner request")
    public void sendAppPutUserToBeOwnerRequest() {
        SerenityRest.when().put(SegoroAPI.APPROVE_USER);
    }
}
