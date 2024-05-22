package com.vk.appium.android.chrome.oktests;

import com.vk.appium.android.chrome.okpages.OkChromeLoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;

public class OkChromeLoginTest extends OkChromeBaseTest {

    @BeforeEach
    @Override
    public void setup() {
        log.info("Setup Test Login Test");
        open("/");
        okLoginPage = new OkChromeLoginPage();
    }

    private static Stream<Arguments> loginUserData() {
        return Stream.of(Arguments.of("technopol71", "technopolisPassword"),
                Arguments.of("technopol71", "technopolisPassword"));
    }

    @DisabledOnJre(JRE.JAVA_11)
    @ParameterizedTest
    @MethodSource("loginUserData")
    @DisplayName("Test Login Success")
    @Tag("LoginSuccess")
    @Timeout(value = 20000, unit = TimeUnit.MILLISECONDS)
    public void testLoginSuccess(String username, String password) {
        log.info("Clicking on login button");
        okLoginPage.login();
        log.info("Input username");
        okLoginPage.username(username);
        log.info("Input password");
        okLoginPage.password(password);
        log.info("Clicking submit button");
        okLoginPage.submit();
        Assertions.assertAll("Login Success",
                () -> Assertions.assertTrue(okLoginPage.getNotificationSideBar().isDisplayed(),
                        "Notification side bar should be visible after login"),
                () -> Assertions.assertTrue(okLoginPage.getEventsSideBar().isDisplayed(),
                        "Events side bar should be visible after login"),
                () -> Assertions.assertTrue(okLoginPage.getGuestsSideBar().isDisplayed(),
                        "Guests side bar should be visible after login"));
    }
}
