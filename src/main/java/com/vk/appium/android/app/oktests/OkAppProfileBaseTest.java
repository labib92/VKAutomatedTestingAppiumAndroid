package com.vk.appium.android.app.oktests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.appium.SelenideAppium;
import com.vk.appium.android.app.configuration.AndroidOkAppCapability;
import com.vk.appium.android.app.okpages.OkAppGoToProfilePage;
import com.vk.appium.android.app.okpages.OkAppLoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class OkAppProfileBaseTest {
    protected static final Logger log = getLogger(lookup().lookupClass());
    protected OkAppLoginPage okAppLoginPage;
    protected final String username = "technopol71";
    protected final String password = "technopolisPassword";

    @BeforeAll
    public static void setupClass() {
        log.info("Setup for all tests");
        Configuration.browser = AndroidOkAppCapability.class.getName();
        Configuration.pageLoadTimeout = 60000;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void setup() {
        log.info("Setup Ok Test");
        log.info("Launch Ok App");
        SelenideAppium.launchApp();
        okAppLoginPage = new OkAppLoginPage();
        log.info("Input username {}", username);
        okAppLoginPage.username(username);
        log.info("Input password {}", password);
        okAppLoginPage.password(password);
        log.info("Press submit button");
        okAppLoginPage.submit();
        log.info("Press skip notification button");
        okAppLoginPage.skipNotification();
        OkAppGoToProfilePage goToProfile = new OkAppGoToProfilePage();
        goToProfile.goToProfilePage();
    }

    @AfterEach
    public void tearDown() {
        log.info("Closing the Ok App");
        Selenide.closeWebDriver();
    }
}
