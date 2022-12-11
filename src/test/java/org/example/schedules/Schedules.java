package org.example.schedules;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.example.hooks.SegoroAPI;

import java.io.File;

import static org.example.hooks.SegoroAPI.TOKEN_OWNER;

public class Schedules {

    public static String POST_SCHEDULE_FIELD_ID = SegoroAPI.URL + "/schedules";

    public static String GET_ALL_SCHEDULES = SegoroAPI.URL + "/schedules";

    public static String GET_SCHEDULE_PARAM = SegoroAPI.URL + "/schedules/{schedule_id}";

    public static String PUT_SCHEDULE_PARAM = SegoroAPI.URL + "/schedules/{schedule_id}";

    public static String DELETE_SCHEDULE_PARAM = SegoroAPI.URL + "/schedules/{schedule_id}";

    @Step("Post schedules")
    public void postScheduleFieldId(File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_OWNER)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("POST schedules invalid body field ID")
    public void postScheduleInvalidBodyFieldId(File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_OWNER )
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("GET all schedules")
    public void getAllSchedules() {
        SerenityRest.given().headers("Authorization", "Bearer " + TOKEN_OWNER );
    }

    @Step("GET schedules valid ID")
    public void getScheduleValidId(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_OWNER )
                .pathParam("schedule_id", id);
    }

    @Step("GET schedules invalid ID")
    public void getScheduleInvalidId(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_OWNER )
                .pathParam("schedule_id", id);
    }

    @Step("GET schedules field ID")
    public void getScheduleFieldId(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_OWNER )
                .pathParam("schedule_id", id);
    }

    @Step("GET schedules invalid field ID")
    public void getScheduleInvalidFieldId(int id) {
        SerenityRest.given().pathParam("user_id", id).headers("Authorization", "Bearer "+ TOKEN_OWNER);
    }

    @Step("PUT schedules ID")
    public void putScheduleId(int id, File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_OWNER )
                .pathParam("schedule_id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("DELETE schedules ID")
    public void deleteScheduleId(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_OWNER )
                .pathParam("schedule_id", id);
    }

    @Step("DELETE schedules invalid ID")
    public void deleteScheduleInvalidId(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_OWNER )
                .pathParam("schedule_id", id);
    }
}
