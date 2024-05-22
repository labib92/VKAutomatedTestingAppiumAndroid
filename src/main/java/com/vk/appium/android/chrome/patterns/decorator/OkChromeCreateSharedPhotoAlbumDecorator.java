package com.vk.appium.android.chrome.patterns.decorator;

import com.codeborne.selenide.SelenideElement;
import com.vk.appium.android.chrome.okpages.OkChromeCreateSharedAlbum;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkChromeCreateSharedPhotoAlbumDecorator extends OkChromeCreateAlbumDecorator {
    private final String albumName;
    private OkChromeCreateSharedAlbum createSharedAlbum;

    public OkChromeCreateSharedPhotoAlbumDecorator(OkChromeCreatePhotoAlbum okChromeCreatePhotoAlbum, String albumName) {
        super(okChromeCreatePhotoAlbum);
        this.albumName = albumName;
    }

    @Override
    public void createPhotoAlbum() {
        createSharedAlbum();
        super.okChromeCreatePhotoAlbum.createPhotoAlbum();
        continueButton();
    }

    private void createSharedAlbum() {
        createSharedAlbum = new OkChromeCreateSharedAlbum();
        createSharedAlbum.goToPhotoSection();
        createSharedAlbum.createAlbum(albumName);
    }

    private void continueButton() {
        createSharedAlbum.clickContinueButton();
    }

    @Override
    public SelenideElement getAlbumName() {
        return $(createSharedAlbum.getTittleName()).shouldBe(visible
                .because("Shared Album tittle should be visible"));
    }
}
