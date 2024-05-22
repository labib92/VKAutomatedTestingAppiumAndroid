package com.vk.appium.android.app.okpages;

import com.codeborne.selenide.SelenideElement;
import com.vk.appium.android.app.load.OkAppLoadablePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkAppLoginPage implements OkAppLoadablePage {
    private static final By USERNAME_FILED = By.xpath(".//android.widget.AutoCompleteTextView[@resource-id='ru.ok.android:id/text_login']");
    private static final By PASSWORD_FIELD = By.xpath(".//android.widget.EditText[@resource-id='ru.ok.android:id/password_text']");
    private static final By LOGIN_BUTTON = By.xpath(".//android.widget.Button[@resource-id='ru.ok.android:id/login_button']");
    private static final By SKIP_NOTIFICATION_BUTTON = By.xpath(".//android.widget.ImageButton[@content-desc='Navigate up']");
    private static final By OPEN_SIDE_MENU_BUTTON = By.xpath(".//android.widget.ImageButton[@content-desc='Open side menu']");

    public OkAppLoginPage() {
        checkPage();
    }

    public void username(String username) {
        $(USERNAME_FILED).shouldBe(visible
                        .because("Username field should be visible before inputting text"))
                .sendKeys(username);
    }

    public void password(String password) {
        $(PASSWORD_FIELD).shouldBe(visible
                        .because("Password field should be visible before inputting text"))
                .sendKeys(password);
    }

    public void submit() {
        $(LOGIN_BUTTON).shouldBe(visible
                        .because("Submit button should be visible before clicking it"))
                .click();
    }

    public void skipNotification() {
        $(SKIP_NOTIFICATION_BUTTON).shouldBe(visible
                        .because("Skip Button should be visible before clicking it"))
                .click();
    }

    public SelenideElement getOpenSideMenuButton() {
        return $(OPEN_SIDE_MENU_BUTTON).shouldBe(visible
                .because("Open side menu button should be visible"));
    }

    @Override
    public void checkPage() {
        $(USERNAME_FILED).shouldBe(visible
                .because("Username field should be visible"));
        $(PASSWORD_FIELD).shouldBe(visible
                .because("Password field should be visible"));
        $(LOGIN_BUTTON).shouldBe(visible
                .because("Login button should be visible"));
    }
}
