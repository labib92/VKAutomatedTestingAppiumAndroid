package com.vk.appium.android.app.okpages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.vk.appium.android.app.okpages.OkAppBasePage.OPEN_SIDE_MENU_BUTTON;
import static com.vk.appium.android.app.okpages.OkAppBasePage.PROFILE_BUTTON;

public class OkAppCreateMoment extends OKAppProfilePage {
    private static final By ADD_MOMENT = By.xpath(".//android.widget.TextView[@resource-id='ru.ok.android:id/avatar_dialog_add_daily_photo']");
    private static final By ALLOW_ACCESS_TO_CAMERA_BUTTON = By.xpath(".//android.widget.Button[@resource-id='ru.ok.android:id/camera__btn_request_permission']");
    private static final By WHILE_USING_THIS_APP_BUTTON = By.xpath(".//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']");
    private static final By SWITCH_CAMERA_BUTTON = By.xpath(".//android.widget.ImageView[@content-desc='Switch camera']");
    private static final By TAKE_PHOTO_BUTTON = By.xpath(".//android.widget.ProgressBar[@content-desc='Take a photo']");
    private static final By SHARE_MOMENT_BUTTON = By.xpath(".//android.view.ViewGroup[@resource-id='ru.ok.android:id/bottom_panel_action_btn']");
    private static final By PROFILE_PICTURE_WITH_CIRCLE = By.xpath(".//android.widget.ImageView[@resource-id='ru.ok.android:id/profile_dm_state_circle']");
    private static final By SHOW_MOMENTS_BUTTON = By.xpath(".//android.widget.TextView[@resource-id='ru.ok.android:id/avatar_dialog_daily_photo']");
    private static final By OPEN_MOMENT_MENU_BUTTON = By.xpath(".//android.widget.ImageView[@content-desc='Open menu']");
    private static final By DELETE_MOMENT_BUTTON = By.xpath(".//android.widget.FrameLayout[@resource-id='ru.ok.android:id/bottom_sheet_full']/android.widget.LinearLayout/android.view.ViewGroup[1]");
    private static final By DELETE_MOMENT_CONFIRM_BUTTON = By.xpath(".//android.widget.TextView[@resource-id='ru.ok.android:id/md_buttonDefaultPositive']");

    public OkAppCreateMoment() {
        super();
    }

    public void createMoment() {
        $(PROFILE_PICTURE).shouldBe(visible
                        .because("Profile picture should be visible before clicking it"))
                .click();
        $(ADD_MOMENT).shouldBe(visible
                        .because("Add moment should be visible before clicking it"))
                .click();
        $(ALLOW_ACCESS_TO_CAMERA_BUTTON).shouldBe(visible
                        .because("Allow access to camera button should be visible before clicking it"))
                .click();
        $(WHILE_USING_THIS_APP_BUTTON).shouldBe(visible
                        .because("While using the app button should be visible before clicking it"))
                .click();
        $(SWITCH_CAMERA_BUTTON).shouldBe(visible
                        .because("Switch camera should be visible before clicking it"))
                .click();
        $(TAKE_PHOTO_BUTTON).shouldBe(visible
                        .because("Take photo should be visible before clicking it"))
                .click();
        $(SHARE_MOMENT_BUTTON).shouldBe(visible
                        .because("Share moment button should be visible before clicking it"))
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

    public void deleteMoment() {
        $(PROFILE_PICTURE_WITH_CIRCLE).shouldBe(visible.because(
                        "Profile picture with circle should be visible before clicking it"))
                .click();
        $(SHOW_MOMENTS_BUTTON).shouldBe(visible
                        .because("Show moment should be visible before clicking it"))
                .click();
        $(OPEN_MOMENT_MENU_BUTTON).shouldBe(visible
                        .because("Actionbar posting item should be visible before clicking it"))
                .click();
        $(DELETE_MOMENT_BUTTON).shouldBe(visible
                        .because("Delete moment button should be visible before clicking it"))
                .click();
        $(DELETE_MOMENT_CONFIRM_BUTTON).shouldBe(visible
                        .because("Delete moment confirm button should be visible before clicking it"))
                .click();
    }

    public SelenideElement getProfilePictureWithCircle() {
        return $(PROFILE_PICTURE_WITH_CIRCLE).shouldBe(visible
                .because("Profile picture with circle should be visible"));
    }
}
