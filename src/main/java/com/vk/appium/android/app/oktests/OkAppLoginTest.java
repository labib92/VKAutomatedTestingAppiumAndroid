package com.vk.appium.android.app.oktests;

import com.codeborne.selenide.appium.SelenideAppium;
import com.vk.appium.android.app.okpages.OkAppLoginPage;
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

@DisplayName("Ok app login test")
public class OkAppLoginTest extends OkAppBaseTest {

    @BeforeEach
    @Override
    public void setup() {
        log.info("Setup Test Login Test");
        SelenideAppium.launchApp();
        okAppLoginPage = new OkAppLoginPage();
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
        log.info("Input username {}", username);
        okAppLoginPage.username(username);
        log.info("Input password {}", password);
        okAppLoginPage.password(password);
        log.info("Press submit button");
        okAppLoginPage.submit();
        log.info("Press skip notification button");
        okAppLoginPage.skipNotification();
        Assertions.assertTrue(okAppLoginPage.getOpenSideMenuButton().isDisplayed(),
                "Open side menu button should be visible after successful login");
    }
}
