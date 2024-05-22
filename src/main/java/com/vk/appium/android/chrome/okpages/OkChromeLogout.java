package com.vk.appium.android.chrome.okpages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class OkChromeLogout extends OkChromeProfilePage {
    private static final By LOGOUT_BUTTON = By.xpath(".//a[@aria-label='Log out']");
    private static final By INPUT_LOGOUT_BUTTON = By.xpath(".//input[@aria-label='Log out']");
    private static final By CONFIRM_LOGOUT = By.xpath(".//input[@name='button_logoff']");

    public OkChromeLogout() {
        super();
    }

    public void logoutSuccess() {
        SelenideElement element = $(LOGOUT_BUTTON).shouldBe(exist
                .because("Logout button should be exist before clicking it"));
        executeJavaScript("arguments[0].click();", element);
        $(INPUT_LOGOUT_BUTTON).shouldBe(visible
                        .because("Input logout button should be visible before clicking it"))
                .click();
        $(CONFIRM_LOGOUT).shouldBe(visible
                        .because("Confirm logout should be visible before clicking it"))
                .click();
    }
}
