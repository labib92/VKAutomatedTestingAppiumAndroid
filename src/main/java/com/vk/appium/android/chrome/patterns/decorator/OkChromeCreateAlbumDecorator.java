package com.vk.appium.android.chrome.patterns.decorator;

import com.codeborne.selenide.SelenideElement;

public class OkChromeCreateAlbumDecorator implements OkChromeCreatePhotoAlbum {
    protected final OkChromeCreatePhotoAlbum okChromeCreatePhotoAlbum;

    public OkChromeCreateAlbumDecorator(OkChromeCreatePhotoAlbum okChromeCreatePhotoAlbum) {
        this.okChromeCreatePhotoAlbum = okChromeCreatePhotoAlbum;
    }

    @Override
    public void createPhotoAlbum() {
        okChromeCreatePhotoAlbum.createPhotoAlbum();
    }

    @Override
    public void deletePhotoAlbum() {
        okChromeCreatePhotoAlbum.deletePhotoAlbum();
    }

    @Override
    public SelenideElement getAlbumName() {
        return okChromeCreatePhotoAlbum.getAlbumName();
    }
}
