package starter.Auth;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class DeleteUserByIDStepDef {
    @Steps
    SegoroAPI segoroAPI;

    @Given("Delete user with id {int}")
    public void deleteUserWithIdId(int id) {
        segoroAPI.deleteUser(id);
    }

    @When("Send delete user request")
    public void sendDeleteUserRequest() {
        SerenityRest.when().delete(SegoroAPI.DELETE_USER);
    }
}
