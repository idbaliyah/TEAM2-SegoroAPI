package starter.Auth;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.Matchers.equalTo;

public class GetUserByIDStepDef {
    @Steps
    SegoroAPI segoroAPI;
    @Given("Get single user with parameter user {int}")
    public void getSingleUserWithParameterUserId(int id) {
        segoroAPI.getSingleUsers(id);
    }

    @When("Send get single user request")
    public void sendGetSingleUserRequest() {
        SerenityRest.when().get(SegoroAPI.SET_SINGLE_USER);
    }

    @And("Response body page user be {int}")
    public void responseBodyPageUserBeId(int id) {
        SerenityRest.then().body(SegoroResponses.DATA_ID,equalTo(id));
    }
}
