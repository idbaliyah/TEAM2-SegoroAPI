package org.example.bookings;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.example.hooks.SegoroAPI;

import java.io.File;

public class BookingStepDef {
    @Steps
    Bookings bookings;

    @Given("get all bookings invalid URL")
    public void getAllBookingsInvalidURL() {
        bookings.getAllBookingsInvalidUrl();
    }

    @When("send all bookings invalid URL request")
    public void sendAllBookingsInvalidUrlRequest() {
        SerenityRest.when().get(Bookings.ALL_BOOKINGS_INVALID_URL);
    }

    @Then("status code is {int} not found")
    public void statusCodeIsNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }


    @Given("get all bookings")
    public void getAllBookings() {
        bookings.getAllBookingsValidUrl();
    }

    @When("send all bookings request")
    public void sendAllBookingsRequest() {
        SerenityRest.when().get(Bookings.ALL_BOOKINGS);
    }

    @And("validate get all bookings json schema validator")
    public void validateGetAllBookingsJsonSchemaValidator() {
        File json = new File(SegoroAPI.JSON_SCHEMA + "/Bookings/BookingSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("get booking invalid id {int}")
    public void getBookingInvalidId(int id) {
        bookings.getBookingInvalidUserId(id);
    }

    @When("send get booking id request")
    public void sendGetBookingIdRequest() {
        SerenityRest.when().get(Bookings.BOOKING_USER);
    }

    @Given("get booking id {int}")
    public void getBookingId(int id) {
        bookings.getBookingValidUserId(id);
    }

    @Given("add booking to cart")
    public void addBookingToCart() {
        File json = new File(SegoroAPI.JSON_REQ_BODY + "/AddToCartBooking.json");
        bookings.postAddBookingToCart(json);
    }

    @When("send add booking request")
    public void sendAddBookingRequest() {
        SerenityRest.when().post(Bookings.ADD_CART);
    }

    @And("validate add booking json schema validator")
    public void validateAddBookingJsonSchemaValidator() {
        File json = new File(SegoroAPI.JSON_SCHEMA + "/Bookings/BookingSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("add payment valid id {int}")
    public void addPaymentValidId(int id) {
        File json = new File(SegoroAPI.JSON_REQ_BODY + "/EditSchedules.json");
        bookings.postAddBookingPayment(id, json);
    }

    @When("send add payment request")
    public void sendAddPaymentRequest() {
        SerenityRest.when().post(Bookings.ADD_PAYMENT);
    }

    @Given("delete booking valid id {int}")
    public void deleteBookingValidId(int id) {
        bookings.deleteBooking(id);
    }

    @When("send delete booking request")
    public void sendDeleteBookingRequest() {
        SerenityRest.when().delete(Bookings.DELETE_BOOKING);
    }

}
