package com.vk.appium.android.app.oktests;

import com.codeborne.selenide.Selenide;
import com.vk.appium.android.app.okpages.OkAppAddDescription;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

@DisplayName("Ok app create description Test Class")
public class OkAppAddDescriptionTest extends OkAppProfileBaseTest {
    private final String description = "I am a BOT.";
    private OkAppAddDescription okAppAddDescription;

    @AfterEach
    @Override
    public void tearDown() {
        log.info("Deleting description");
        okAppAddDescription.deleteDescription();
        log.info("Closing the Ok App");
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("Test Create Description Success")
    @Tag("CreateDescriptionSuccess")
    @Timeout(value = 30000, unit = TimeUnit.MILLISECONDS)
    public void testAddDescriptionSuccess() {
        okAppAddDescription = new OkAppAddDescription();
        log.info("creating description");
        okAppAddDescription.addDescription(description);
        Assertions.assertEquals(okAppAddDescription.getDescriptionText(), description,
                "The text description should be equal to " + description +
                        " after successfully creating a description");
    }
}
