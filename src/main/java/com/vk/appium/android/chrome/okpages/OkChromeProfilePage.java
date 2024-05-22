package com.vk.appium.android.chrome.okpages;

import com.vk.appium.android.chrome.patterns.load.OkChromeLoadablePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkChromeProfilePage implements OkChromeLoadablePage {
    protected static final By PHOTO_BUTTON = By.xpath(".//a[contains(text(),'Photos')]");
    protected static final By FRIENDS_BUTTON = By.xpath(".//a[contains(text(),'Friends')]");
    protected static final By GROUPS_BUTTON = By.xpath(".//a[contains(text(),'Groups')]");

    public OkChromeProfilePage() {
        checkPage();
    }

    @Override
    public void checkPage() {
        $(PHOTO_BUTTON).shouldBe(visible
                .because("Photo button should be visible"));
        $(FRIENDS_BUTTON).shouldBe(visible
                .because("Friends button should be visible"));
        $(GROUPS_BUTTON).shouldBe(visible
                .because("Groups button should be visible"));
    }
}
