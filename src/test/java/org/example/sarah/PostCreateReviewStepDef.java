package org.example.sarah;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class PostCreateReviewStepDef {
    @Steps
    SegoroAPI segoroAPI;
    @Given("Post create review with valid data")
    public void postCreateReviewWithValidData() {
        segoroAPI.createReview();
    }

    @When("Send post review request")
    public void sendPostReviewRequest() {
        SerenityRest.when().post(SegoroAPI.CREATE_REVIEW);
    }
}
