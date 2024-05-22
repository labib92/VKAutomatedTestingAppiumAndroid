package com.vk.appium.android.app.okpages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkAppGoToProfilePage extends OkAppBasePage {

    public OkAppGoToProfilePage() {
        super();
    }

    public void goToProfilePage() {
        $(OPEN_SIDE_MENU_BUTTON).shouldBe(visible
                        .because("Open sid menu button should be visible before clicking it"))
                .click();
        $(LATER_NOTIFICATION_BUTTON).shouldBe(visible
                        .because("Later notification button should be visible before clicking it"))
                .click();
        $(PROFILE_BUTTON).shouldBe(visible
                        .because("Profile button should be visible before clicking it"))
                .click();
    }
}
