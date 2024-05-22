package com.vk.appium.android.chrome.okpages;


import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkChromeCreateAlbum extends OkChromeProfilePage {
    protected static final By TEXT_FIELD_NAME = By.xpath(".//input[@id='field_name']");

    public OkChromeCreateAlbum() {
        super();
    }

    public void goToPhotoSection() {
        $(PHOTO_BUTTON).shouldBe(visible
                        .because("Photo button should be visible before clicking it"))
                .click();
    }
}
