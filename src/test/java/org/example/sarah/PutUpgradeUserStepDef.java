package org.example.sarah;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class PutUpgradeUserStepDef {
    @Steps
    SegoroAPI segoroAPI;
    @Given("Post upgrade user to owner")
    public void postUpgradeUserToOwner() {
        segoroAPI.upgradeUser();
    }

    @When("Send post upgrade user request")
    public void sendPostUpgradeUserRequest() {
        SerenityRest.when().post(SegoroAPI.UPGRADE_USER);
    }
}
