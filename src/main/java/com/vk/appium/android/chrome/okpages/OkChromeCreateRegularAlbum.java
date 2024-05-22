package com.vk.appium.android.chrome.okpages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class OkChromeCreateRegularAlbum extends OkChromeCreateAlbum {
    private static final By CREATE_PHOTO_ALBUM_BUTTON = By.xpath(".//a[@aria-label='Create photo album']");
    private static final By PHOTO_ALBUM_TAB = By.xpath(".//span[contains(text(),'Photo albums')]");
    private static final By TITLE_ALBUM_NAME = By.xpath(".//p[@class='ep-ttl-txt']");
    private static final By EVERYONE_CHECKBOX = By.xpath(".//input[@id='field_toPublic']");

    public OkChromeCreateRegularAlbum() {
        super();
    }

    public void createAlbum(String photoAlbumName) {
        SelenideElement element = $(PHOTO_ALBUM_TAB).should(exist
                .because("Photo album should exist before clicking it"));
        executeJavaScript("arguments[0].click();", element);
        $(CREATE_PHOTO_ALBUM_BUTTON).shouldBe(visible
                        .because("Create photo album button should be visible before clicking it"))
                .click();
        $(TEXT_FIELD_NAME).shouldBe(visible
                        .because("Text field name should be visible before typing the text"))
                .type(photoAlbumName);
    }

    public void uncheckVisibilityCheckBox(By locator) {
        SelenideElement everyone_element = $(EVERYONE_CHECKBOX);
        everyone_element.shouldBe(checked
                .because("Everyone checkbox should be checked"));
        executeJavaScript("arguments[0].checked = false;", everyone_element);
        everyone_element.shouldNotBe(checked
                .because("Everyone checkbox should not be checked after unchecking it"));
        SelenideElement radioButton = $(locator);
        radioButton.shouldNotBe(checked
                .because("Radio button should not be checked before checking it"));
        executeJavaScript("arguments[0].checked = true;", radioButton);
        radioButton.shouldBe(checked
                .because("Radio button should be checked after checking it"));
    }

    public By getTittleName() {
        return TITLE_ALBUM_NAME;
    }
}
