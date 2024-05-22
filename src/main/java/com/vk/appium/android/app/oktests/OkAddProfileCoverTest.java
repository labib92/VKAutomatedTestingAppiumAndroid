package com.vk.appium.android.app.oktests;


import com.codeborne.selenide.Selenide;
import com.vk.appium.android.app.okpages.OkAppAddProfileCover;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;


@DisplayName("Ok app add profile cover Test Class")
public class OkAddProfileCoverTest extends OkAppProfileBaseTest {
    private OkAppAddProfileCover addProfile;

    @AfterEach
    @Override
    public void tearDown() {
        log.info("Delete Profile Cover");
        addProfile.deleteProfileCover();
        log.info("Closing the Ok App");
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("Test Add Profile Cover Success")
    @Tag("AddProfileCover")
    @Timeout(value = 40000, unit = TimeUnit.MILLISECONDS)
    public void testCreateProfileCoverSuccess() {
        addProfile = new OkAppAddProfileCover();
        log.info("Adding Profile Cover Image");
        addProfile.addProfileCover();
        Assertions.assertTrue(addProfile.getImage().isDisplayed(),
                "Profile image cover should be visible after adding a profile cover image");
    }
}
