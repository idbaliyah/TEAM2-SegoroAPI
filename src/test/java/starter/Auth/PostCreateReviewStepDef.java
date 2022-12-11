package starter.Auth;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

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
