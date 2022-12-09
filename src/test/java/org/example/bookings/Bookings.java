package org.example.bookings;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.example.hooks.SegoroAPI;

import java.io.File;

import static org.example.hooks.SegoroAPI.TOKEN_USER;

public class Bookings {

    public static String ALL_BOOKINGS_INVALID_URL = SegoroAPI.URL + "/bookingss";

    public static String ALL_BOOKINGS = SegoroAPI.URL + "/bookings";

    public static String BOOKING_USER = ALL_BOOKINGS + "{id}";

    public static String ADD_CART = ALL_BOOKINGS + "/addtocart";

    public static String ADD_PAYMENT = ALL_BOOKINGS + "/bookings/{id}/payment";

    public static String DELETE_BOOKING = ALL_BOOKINGS + "/{id}";

    @Step("GET all bookings invalid URL")
    public void getAllBookingsInvalidUrl() {
        SerenityRest.given().headers("Authorization", "Bearer" + TOKEN_USER );
    }

    @Step("GET all bookings valid URL")
    public void getAllBookingsValidUrl() {
        SerenityRest.given().headers("Authorization", "Bearer" + TOKEN_USER );
    }

    @Step("GET booking valid user ID")
    public void getBookingValidUserId(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer" + TOKEN_USER )
                .pathParam("user_ID", id);
    }

    @Step("GET booking invalid user ID")
    public void getBookingInvalidUserId(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer" + TOKEN_USER )
                .pathParam("user_ID", id);
    }

    @Step("POST add to booking cart")
    public void postAdCart(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer" + TOKEN_USER )
                .pathParam("booking_id", id);
    }

    @Step("POST add booking to cart")
    public void postAddBookingToCart(File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer" + TOKEN_USER )
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("POST add booking payments")
    public void postAddBookingPayment(int id, File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer" + TOKEN_USER )
                .pathParam("booking_id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("DELETE booking valid id")
    public void deleteBooking(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer" + TOKEN_USER )
                .pathParam("booking_id", id);
    }
}
