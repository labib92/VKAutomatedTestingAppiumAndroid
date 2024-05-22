package com.vk.appium.android.app.oktests;

import com.codeborne.selenide.Selenide;
import com.vk.appium.android.app.okpages.OkAppCreateMoment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

@DisplayName("Ok app create moment Test Class")
public class OkAppCreateMomentTest extends OkAppProfileBaseTest {
    private OkAppCreateMoment moment;

    @AfterEach
    @Override
    public void tearDown() {
        log.info("Deleting Moment");
        moment.deleteMoment();
        log.info("Closing the Ok App");
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("Test Create Moment Success")
    @Tag("CreateMomentSuccess")
    @Timeout(value = 40000, unit = TimeUnit.MILLISECONDS)
    public void testCreateMomentSuccess() {
        moment = new OkAppCreateMoment();
        log.info("Creating Moment");
        moment.createMoment();
        Assertions.assertTrue(moment.getProfilePictureWithCircle().isDisplayed(),
                "Profile picture with circle should be visible after creating a moment.");
    }
}
