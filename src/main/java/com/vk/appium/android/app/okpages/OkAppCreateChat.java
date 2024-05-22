package com.vk.appium.android.app.okpages;

import com.vk.appium.android.app.oktests.OkAppBaseTest;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkAppCreateChat extends OkAppBaseTest {
    private static final By MESSAGE_MENU_BUTTON = By.xpath(".//android.view.ViewGroup[@content-desc='Messages']");
    private static final By CREATE_CHAT_BUTTON = By.xpath(".//android.widget.ImageButton[@content-desc='Create chat']");
    private static final By CREATE_CHAT_FOR_YOURSELF_BUTTON = By.xpath(".//android.widget.Button[@resource-id='ru.ok.android:id/new_contacts_picker_empty_contacts_button_create_chat']");
    private static final By CHAT_NAME_TEXT_INPUT = By.xpath(".//android.widget.EditText[@resource-id='ru.ok.android:id/fragment_create_chat_title_chat']");
    private static final By CHAT_MESSAGE_TEXT_INPUT = By.xpath(".//android.widget.EditText[@resource-id='ru.ok.android:id/fragment_create_chat_first_message']");
    private static final By CREATE_A_CHAT_BUTTON = By.xpath(".//android.widget.Button[@resource-id='ru.ok.android:id/fragment_create_chat_button_create_chat']");
    private static final By CHAT_TITTLE_AVATAR_BUTTON = By.xpath(".//android.view.View[@resource-id='ru.ok.android:id/chat_title__tav_avatar']");
    private static final By CHAT_SETTINGS_BUTTON = By.xpath(".//android.view.ViewGroup[@resource-id='ru.ok.android:id/chat_profile_settings']");
    private static final By REMOVE_CHAT_BUTTON = By.xpath(".//android.widget.TextView[@resource-id='ru.ok.android:id/frg_chat_settings__tv_action_delete_chat']");
    private static final By DELETE_CONFORMATION_BUTTON = By.xpath(".//android.widget.TextView[@resource-id='ru.ok.android:id/md_buttonDefaultPositive']");
    private static final By MESSAGE_TEXT = By.xpath(".//android.widget.TextView[@resource-id='ru.ok.android:id/view_message__tv_text']");
    private static final By CHAT_TITTLE_TEXT = By.xpath(".//android.widget.TextView[@resource-id='ru.ok.android:id/chat_title__tv_title']");

    public OkAppCreateChat() {
        super();
    }

    public void createChat(String chatName, String message) {
        $(MESSAGE_MENU_BUTTON).shouldBe(visible
                        .because("Message menu button should be visible before clicking it"))
                .click();
        $(CREATE_CHAT_BUTTON).shouldBe(visible
                        .because("Create chat button should be visible before clicking it"))
                .click();
        $(CREATE_CHAT_FOR_YOURSELF_BUTTON).shouldBe(visible
                        .because("Create chat for yourself button should be visible before clicking it"))
                .click();
        $(CHAT_NAME_TEXT_INPUT).shouldBe(visible
                        .because("Chat name text input should be visible before inputting the text"))
                .sendKeys(chatName);
        $(CHAT_MESSAGE_TEXT_INPUT).shouldBe(visible
                        .because("Chat message text input should be visible before inputting the text"))
                .sendKeys(message);
        $(CREATE_A_CHAT_BUTTON).shouldBe(visible
                        .because("Create a chat button should be visible before clicking it"))
                .click();
    }

    public void deleteChat() {
        $(CHAT_TITTLE_AVATAR_BUTTON).shouldBe(visible
                        .because("Chat title avatar button should be visible before clicking it"))
                .click();
        $(CHAT_SETTINGS_BUTTON).shouldBe(visible
                        .because("Chat settings button should be visible before clicking it"))
                .click();
        $(REMOVE_CHAT_BUTTON).shouldBe(visible
                        .because("Remove chat button should be visible before clicking it"))
                .click();
        $(DELETE_CONFORMATION_BUTTON).shouldBe(visible
                        .because("Delete conformation button should be visible before clicking it"))
                .click();
    }

    public String getMessageText() {
        return $(MESSAGE_TEXT).shouldBe(visible
                        .because("Message text should be visible before getting the text"))
                .getText();
    }

    public String getChatTittleText() {
        return $(CHAT_TITTLE_TEXT).shouldBe(visible
                        .because("Chat tittle text should be visible before getting the text"))
                .getText();
    }
}
