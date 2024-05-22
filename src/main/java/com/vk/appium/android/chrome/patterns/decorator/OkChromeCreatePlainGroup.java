package com.vk.appium.android.chrome.patterns.decorator;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class OkChromeCreatePlainGroup implements OkChromeCreatePhotoAlbum {

    @Override
    public void createPhotoAlbum() {
        $(SAVE_ALBUM_BUTTON).shouldBe(visible
                        .because("Save album button should be visible before clicking it"))
                .click();
    }

    @Override
    public void deletePhotoAlbum() {
        SelenideElement element = $(DELETE_ALBUM).shouldBe(hidden
                .because("Delete album button should be hidden before clicking it"));
        executeJavaScript("arguments[0].click();", element);
        $(CONFIRM_DELETE_BUTTON).shouldBe(visible
                        .because("Confirm delete album should be visible before clicking it"))
                .click();
    }

    @Override
    public SelenideElement getAlbumName() {
        return null;
    }
}
