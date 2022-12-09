package org.example.history;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.example.hooks.SegoroAPI;

import static org.example.hooks.SegoroAPI.TOKEN_OWNER;

public class History {
    public static String HISTORY = SegoroAPI.URL + "/history/{schedule_id}";

    @Step("GET history valid ID")
    public void getHistoryId(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer" + TOKEN_OWNER )
                .pathParam("schedule_id", id);
    }

    @Step("DELETE schedules invalid ID")
    public void getHistoryInvalidId(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer" + TOKEN_OWNER )
                .pathParam("schedule_id", id);
    }

}
