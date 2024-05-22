package com.vk.appium.android.chrome.okpages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkChromeLoginPage {
    private static final By LOGIN_BUTTON = By.xpath(".//input[@name='loginButton']");
    private static final By REGISTER_BUTTON = By.xpath(".//input[@name='registerButton']");
    private static final By USERNAME_INPUT = By.xpath(".//input[@id='field_login']");
    private static final By PASSWORD_INPUT = By.xpath(".//input[@id='field_password']");
    private static final By SUBMIT_BUTTON = By.xpath(".//input[@name='button_login']");
    private static final By MESSAGE_TOOLBAR = By.xpath(".//a[@title='Messages']");
    private static final By DISCUSSIONS_TOOLBAR = By.xpath(".//a[@title='Discussions']");
    private static final By NOTIFICATIONS_TOOLBAR = By.xpath(".//a[@title='Notifications']");

    public OkChromeLoginPage() {
        checkPage();
    }

    public void login() {
        $(LOGIN_BUTTON).shouldBe(visible
                .because("Login button should be visible before clicking it")).click();
    }

    public void username(String username) {
        $(USERNAME_INPUT).shouldBe(visible
                        .because("Username input field should be visible before inputting text"))
                .sendKeys(username);
    }

    public void password(String password) {
        $(PASSWORD_INPUT).shouldBe(visible
                        .because("Password input field should be visible before inputting text"))
                .sendKeys(password);
    }

    public void submit() {
        $(SUBMIT_BUTTON).shouldBe(visible
                        .because("Submit button should be visible before clicking it"))
                .click();
    }

    private void checkPage() {
        $(LOGIN_BUTTON).shouldBe(visible
                .because("Login button should be visible when open the login page"));
        $(REGISTER_BUTTON).shouldBe(visible
                .because("Register button should be visible when open the ok login page"));
    }

    public SelenideElement getNotificationSideBar() {
        return $(MESSAGE_TOOLBAR).shouldBe(visible
                .because("Message toolbar should be visible"));
    }

    public SelenideElement getEventsSideBar() {
        return $(DISCUSSIONS_TOOLBAR).should(visible
                .because("Discussions toolbar should be visible"));
    }

    public SelenideElement getGuestsSideBar() {
        return $(NOTIFICATIONS_TOOLBAR).should(visible
                .because("Notification toolbar should be visible"));
    }
}
