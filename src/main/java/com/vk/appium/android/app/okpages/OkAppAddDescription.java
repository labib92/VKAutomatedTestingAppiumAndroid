package com.vk.appium.android.app.okpages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkAppAddDescription extends OKAppProfilePage {
    private static final By ADD_DESCRIPTION_TEXT_INPUT = By.xpath(".//android.widget.EditText[@resource-id='ru.ok.android:id/profile_add_description']");
    private static final By SAVE_DESCRIPTION_BUTTON = By.xpath(".//android.widget.Button[@resource-id='ru.ok.android:id/primary_btn']");
    private static final By MAIN_PROFILE_BUTTON = By.xpath(".//android.widget.TextView[@resource-id='ru.ok.android:id/item_title' and @text='Main']");
    private static final By DESCRIPTION_FIELD = By.xpath(".//android.widget.EditText[@resource-id='ru.ok.android:id/et_user_description']");
    private static final By SAVE_BUTTON = By.xpath(".//android.view.ViewGroup[@resource-id='ru.ok.android:id/btn_apply']");

    public OkAppAddDescription() {
        super();
    }

    public void addDescription(String description) {

        $(ADD_DESCRIPTION_BUTTON).shouldBe(visible
                        .because("Add description should be visible before clicking it"))
                .click();
        $(ADD_DESCRIPTION_TEXT_INPUT).shouldBe(visible
                        .because("Add description should be visible before inputting text"))
                .sendKeys(description);
        $(SAVE_DESCRIPTION_BUTTON).shouldBe(visible
                        .because("Save description button should be visible before clicking it"))
                .click();
        $(EDIT_PROFILE_BUTTON).shouldBe(visible
                        .because("Edit profile button should be visible before clicking it"))
                .click();
        $(MAIN_PROFILE_BUTTON).shouldBe(visible
                        .because("Main profile button should be visible before clicking it"))
                .click();
    }

    public void deleteDescription() {
        $(DESCRIPTION_FIELD).shouldBe(visible
                        .because("Description text field should be visible before deleting the text"))
                .clear();
        $(SAVE_BUTTON).shouldBe(visible
                        .because("Save button should be visible before clicking it"))
                .click();
    }

    public String getDescriptionText() {
        return $(DESCRIPTION_FIELD).shouldBe(visible
                .because("Description text should be visible")).getText();
    }
}
