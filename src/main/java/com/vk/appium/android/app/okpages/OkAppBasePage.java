package com.vk.appium.android.app.okpages;

import com.vk.appium.android.app.load.OkAppLoadablePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkAppBasePage implements OkAppLoadablePage {
    protected static final By OPEN_SIDE_MENU_BUTTON = By.xpath(".//android.widget.ImageButton[@content-desc='Open side menu']");
    protected static final By LATER_NOTIFICATION_BUTTON = By.xpath(".//android.widget.TextView[@resource-id='ru.ok.android:id/md_buttonDefaultNegative']");
    protected static final By PROFILE_BUTTON = By.xpath(".//android.widget.TextView[@resource-id='ru.ok.android:id/tv_description']");
    protected static final By MOMENTS_BUTTON = By.xpath(".//android.widget.RadioButton[@resource-id='ru.ok.android:id/moments_button']");
    protected static final By INTERESTS_BUTTON = By.xpath(".//android.widget.RadioButton[@resource-id='ru.ok.android:id/hobbies_button']");

    public OkAppBasePage() {
        checkPage();
    }

    @Override
    public void checkPage() {
        $(OPEN_SIDE_MENU_BUTTON).shouldBe(visible
                .because("Open side menu button should be visible"));
        $(MOMENTS_BUTTON).shouldBe(visible
                .because("Moment button should be visible"));
        $(INTERESTS_BUTTON).shouldBe(visible
                .because("Interests button should be visible"));
    }
}
