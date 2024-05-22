package com.vk.appium.android.chrome.okpages;

import com.vk.appium.android.app.load.OkAppLoadablePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class OkChromeBasePage implements OkAppLoadablePage {

    private static final By GO_TO_PROFILE = By.xpath(".//a[@aria-label='Go to profile']");
    private static final By MESSAGE_TOOLBAR = By.xpath(".//a[@title='Messages']");
    private static final By DISCUSSIONS_TOOLBAR = By.xpath(".//a[@title='Discussions']");
    private static final By NOTIFICATIONS_TOOLBAR = By.xpath(".//a[@title='Notifications']");
    private static final By NEWS_FEED_TOOLBAR = By.xpath(".//a[@title='News Feed']");
    private static final By CLOSE_BUTTON = By.xpath(".//input[@name='button_close']");

    public OkChromeBasePage() {
        checkPage();
    }

    @Override
    public void checkPage() {
        $(MESSAGE_TOOLBAR).shouldBe(visible
                .because("Message toolbar should be visible"));
        $(DISCUSSIONS_TOOLBAR).should(visible
                .because("Discussions toolbar should be visible"));
        $(NOTIFICATIONS_TOOLBAR).should(visible
                .because("Notification toolbar should be visible"));
        if ($(CLOSE_BUTTON).isDisplayed()) {
            executeJavaScript("arguments[0].click();", $(CLOSE_BUTTON));
        }
    }

    public void goToProfilePage() {
        $(GO_TO_PROFILE).shouldBe(visible
                        .because("go to profile page click area should be visible before clicking it"))
                .click();
    }

    public void clickNewsFeedToolbar() {
        $(NEWS_FEED_TOOLBAR).shouldBe(visible
                .because("Message toolbar should be visible")).click();
    }
}
