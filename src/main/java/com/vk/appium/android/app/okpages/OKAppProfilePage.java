package com.vk.appium.android.app.okpages;

import com.vk.appium.android.app.load.OkAppLoadablePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OKAppProfilePage implements OkAppLoadablePage {
    protected static final By ADD_DESCRIPTION_BUTTON = By.xpath(".//android.widget.TextView[@resource-id='ru.ok.android:id/add_bio']");
    protected static final By EDIT_PROFILE_BUTTON = By.xpath(".//android.widget.Button[@content-desc='Edit profile']");
    protected static final By PROFILE_PICTURE = By.xpath(".//android.widget.ImageView[@content-desc='Profile picture']");
    protected static final By NEWS_FEED_BUTTON = By.xpath(".//android.view.ViewGroup[@content-desc='News Feed']");

    public OKAppProfilePage() {
        checkPage();
    }

    @Override
    public void checkPage() {
        $(ADD_DESCRIPTION_BUTTON).shouldBe(visible
                .because("Add description should be visible"));
        $(EDIT_PROFILE_BUTTON).shouldBe(visible
                .because("Edit profile button should be visible"));
        $(PROFILE_PICTURE).shouldBe(visible
                .because("Profile picture should be visible"));
    }
}
