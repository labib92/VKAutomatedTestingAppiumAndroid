package com.vk.appium.android.app.okpages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;


public class OkAppSendChatMessage extends OkAppBasePage {
    private static final By CHAT_TITTLE_AVATAR_BUTTON = By.xpath(".//android.view.View[@resource-id='ru.ok.android:id/chat_title__tav_avatar']");
    private static final By NAVIGATE_UP_BUTTON = By.xpath(".//android.widget.ImageButton[@content-desc='Navigate up']");
    private static final By NEW_TEXT_FIELD = By.xpath(".//android.widget.EditText[@resource-id='ru.ok.android:id/new_message_text']");
    private static final By SEND_MESSAGE_BUTTON = By.xpath(".//android.widget.ImageView[@content-desc='Send']");
    private static final By CHAT_TITTLE_TEXT = By.xpath(".//android.widget.TextView[@resource-id='ru.ok.android:id/chat_title__tv_title']");
    private static final String MESSAGE_TEXT = ".//android.widget.TextView[@text='%s']";


    public OkAppSendChatMessage() {
        checkPage();
    }

    public void sendChatMessage(String message) {
        $(NEW_TEXT_FIELD).shouldBe(visible
                        .because("New text field input should be visible before clicking it"))
                .click();
        $(NEW_TEXT_FIELD).shouldBe(visible
                        .because("New text field input should be visible before inputting text message"))
                .sendKeys(message);
        $(SEND_MESSAGE_BUTTON).shouldBe(visible
                        .because("Send message button should be visible before clicking it"))
                .click();
    }

    public String getChatTittleMessageText() {
        return $(CHAT_TITTLE_TEXT).shouldBe(visible
                        .because("Chat tittle should be visible before getting the text"))
                .getText();
    }

    public String getMessageText(String message) {
        return $(By.xpath(String.format(MESSAGE_TEXT, message))).shouldBe(visible
                        .because("Message text should be visible before getting the text"))
                .getText();
    }

    @Override
    public void checkPage() {
        $(CHAT_TITTLE_AVATAR_BUTTON).shouldBe(visible
                .because("Chat title avatar should be visible"));
        $(NAVIGATE_UP_BUTTON).shouldBe(visible
                .because("Navigate up button should be visible"));
        $(NEW_TEXT_FIELD).shouldBe(visible
                .because("New text field input should be visible before clicking it"));
    }
}
