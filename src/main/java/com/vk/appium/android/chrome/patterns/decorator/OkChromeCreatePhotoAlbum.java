package com.vk.appium.android.chrome.patterns.decorator;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public interface OkChromeCreatePhotoAlbum {
    By SAVE_ALBUM_BUTTON = By.xpath(".//input[@name='button_save']");
    By DELETE_ALBUM = By.xpath(".//span[@class='fi ic-close-16 text-icon-action ic16']");
    By CONFIRM_DELETE_BUTTON = By.xpath(".//input[@name='button_yes']");

    void createPhotoAlbum();

    void deletePhotoAlbum();

    SelenideElement getAlbumName();
}
