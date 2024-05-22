package com.vk.appium.android.chrome.okpages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class OkChromeCreateSharedAlbum extends OkChromeCreateAlbum {
    private static final By SHARED_PHOTO_ALBUM_TAB = By.xpath(".//span[contains(text(),'Shared photo albums')]");
    private static final By CREATE_ALBUM_BUTTON = By.xpath(".//div[@class='base-button __accept __modern']");
    private static final By CONTINUE_BUTTON = By.xpath(".//a[@class='title_aside-link']");
    private static final By TITLE_SHARED_ALBUM_NAME = By.xpath(".//a[@class='emphased albm']");

    public OkChromeCreateSharedAlbum() {
        super();
    }

    public void createAlbum(String photoAlbumName) {
        SelenideElement element = $(SHARED_PHOTO_ALBUM_TAB).should(exist
                .because("Shared photo album should exist before clicking it"));
        executeJavaScript("arguments[0].click();", element);
        $(CREATE_ALBUM_BUTTON).shouldBe(visible
                        .because("Create album button should be visible before clicking it"))
                .click();
        $(TEXT_FIELD_NAME).shouldBe(visible
                        .because("Text field name should be visible before typing the text"))
                .type(photoAlbumName);
    }

    public void clickContinueButton() {
        $(CONTINUE_BUTTON).shouldBe(visible
                        .because("Continue button should be visible before clicking it"))
                .click();
    }

    public By getTittleName() {
        return TITLE_SHARED_ALBUM_NAME;
    }
}
