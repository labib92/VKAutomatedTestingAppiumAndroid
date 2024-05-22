package com.vk.appium.android.chrome.oktests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.vk.appium.android.chrome.configuration.AndroidChromeCapability;
import com.vk.appium.android.chrome.okpages.OkChromeLoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;

import static com.codeborne.selenide.Selenide.open;
import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class OkChromeBaseTest {
    protected static final Logger log = getLogger(lookup().lookupClass());
    protected OkChromeLoginPage okLoginPage;
    protected final String username = "technopol71";
    protected final String password = "technopolisPassword";

    @BeforeAll
    public static void setupClass() {
        log.info("Setup for all tests");
        Configuration.browser = AndroidChromeCapability.class.getName();
        Configuration.baseUrl = "https://m.ok.ru/";
        Configuration.pageLoadTimeout = 60000;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void setup() {
        log.info("Setup Ok Test");
        log.info("Open m.ok.ru");
        open("/");
        okLoginPage = new OkChromeLoginPage();
        okLoginPage.login();
        log.info("Input username {}", username);
        okLoginPage.username(username);
        log.info("Input password {}", password);
        okLoginPage.password(password);
        log.info("Press submit button");
        okLoginPage.submit();
    }

    @AfterEach
    public void tearDown() {
        log.info("Closing the browser");
        Selenide.closeWindow();
    }
}
