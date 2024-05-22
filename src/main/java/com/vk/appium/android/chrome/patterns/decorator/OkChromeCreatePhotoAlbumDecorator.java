package com.vk.appium.android.chrome.patterns.decorator;


import com.codeborne.selenide.SelenideElement;
import com.vk.appium.android.chrome.okpages.OkChromeCreateRegularAlbum;
import com.vk.appium.android.chrome.patterns.elements.VisibilityCheckboxPageElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkChromeCreatePhotoAlbumDecorator extends OkChromeCreateAlbumDecorator {
    private final String albumName;
    private OkChromeCreateRegularAlbum createRegularAlbum;

    public OkChromeCreatePhotoAlbumDecorator(OkChromeCreatePhotoAlbum okChromeCreatePhotoAlbum, String albumName) {
        super(okChromeCreatePhotoAlbum);
        this.albumName = albumName;
    }

    @Override
    public void createPhotoAlbum() {
        createRegularAlbum();
        super.okChromeCreatePhotoAlbum.createPhotoAlbum();
    }

    private void createRegularAlbum() {
        createRegularAlbum = new OkChromeCreateRegularAlbum();
        createRegularAlbum.goToPhotoSection();
        createRegularAlbum.createAlbum(albumName);
        createRegularAlbum.uncheckVisibilityCheckBox(
                VisibilityCheckboxPageElement.getMyPartnerCheckbox());
    }

    @Override
    public SelenideElement getAlbumName() {
        return $(createRegularAlbum.getTittleName()).shouldBe(visible
                .because("Album Title should be visible after creating the album"));
    }
}
