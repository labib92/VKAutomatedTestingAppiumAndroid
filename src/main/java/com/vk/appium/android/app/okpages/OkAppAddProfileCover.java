package com.vk.appium.android.app.okpages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.vk.appium.android.app.okpages.OkAppBasePage.OPEN_SIDE_MENU_BUTTON;
import static com.vk.appium.android.app.okpages.OkAppBasePage.PROFILE_BUTTON;

public class OkAppAddProfileCover extends OKAppProfilePage {
    private static final By CHANGE_COVER_MENU_BUTTON = By.xpath(".//android.view.ViewGroup[@resource-id='ru.ok.android:id/actionbar_change_cover_menu_item']");
    private static final By COVER_SHOW_CASE_BUTTON = By.xpath(".//android.widget.TextView[@resource-id='ru.ok.android:id/main_text']");
    private static final By CHOOSE_FIRST_IMAGE_COVER = By.xpath(".//android.widget.GridView[@resource-id='ru.ok.android:id/rv_cover_list']/android.view.ViewGroup[1]");
    private static final By APPLY_COVER_BUTTON = By.xpath(".//android.widget.Button[@resource-id='ru.ok.android:id/set_cover_btn']");
    private static final By OPEN_IMAGE = By.xpath(".//android.widget.ImageView[@content-desc='Image']");
    private static final By MORE_BUTTON = By.xpath(".//android.widget.Button[@content-desc='More…']");
    private static final By DELETE_PHOTO_BUTTON = By.xpath(".//android.widget.TextView[@text='Delete photo']");
    private static final By CONFIRM_DELETE_BUTTON = By.xpath(".//android.widget.TextView[@resource-id='ru.ok.android:id/md_buttonDefaultPositive']");

    public OkAppAddProfileCover() {
        super();
    }

    public void addProfileCover() {
        $(CHANGE_COVER_MENU_BUTTON).shouldBe(visible
                        .because("Change cover menu should be visible before clicking it"))
                .click();
        $(COVER_SHOW_CASE_BUTTON).shouldBe(visible
                        .because("Cover show case button should be visible before clicking it"))
                .click();
        $(CHOOSE_FIRST_IMAGE_COVER).shouldBe(visible
                        .because("Choose first image cover should be visible before clicking it"))
                .click();
        $(APPLY_COVER_BUTTON).shouldBe(visible
                        .because("Apply cover button should be visible before clicking it"))
                .click();
        $(NEWS_FEED_BUTTON).shouldBe(visible
                        .because("News feed button should be visible before clicking it"))
                .click();
        $(OPEN_SIDE_MENU_BUTTON).shouldBe(visible
                        .because("Open sid menu button should be visible before clicking it"))
                .click();
        $(PROFILE_BUTTON).shouldBe(visible
                        .because("Profile button should be visible before clicking it"))
                .click();
    }

    public void deleteProfileCover() {
        $(OPEN_IMAGE).shouldBe(visible
                        .because("Open image should be visible before clicking it"))
                .click();
        $(MORE_BUTTON).shouldBe(visible
                        .because("More button should be visible before clicking it"))
                .click();
        $(DELETE_PHOTO_BUTTON).shouldBe(visible
                        .because("Delete photo button should be visible before clicking it"))
                .click();
        $(CONFIRM_DELETE_BUTTON).shouldBe(visible
                        .because("Confirm delete button should be visible before clicking it"))
                .click();
    }

    public SelenideElement getImage() {
        return $(OPEN_IMAGE).shouldBe(visible
                .because("Open Image should be visible"));
    }
}