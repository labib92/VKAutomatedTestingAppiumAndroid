package com.vk.appium.android.chrome.okpages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkChromeSendChatMessage extends OkChromeProfilePage {
    private static final By SEND_MESSAGE_INPUT_FIELD = By.xpath(".//div[@data-tsid='write_msg_input-input']");
    private static final By SEND_MESSAGE_BUTTON = By.xpath(".//button[@data-l='t,sendButton']");
    private static final By TEXT_MESSAGE = By.xpath(".//span[@data-tsid='message_text']");

    public OkChromeSendChatMessage() {
        super();
    }

    public void sendChatMessage(String textMessage) {
        $(SEND_MESSAGE_INPUT_FIELD).shouldBe(visible
                        .because("Send Message input field should be visible before typing a message"))
                .type(textMessage);
        $(SEND_MESSAGE_BUTTON).shouldBe(visible
                        .because("Send Message Button should be visible before clicking it"))
                .click();
    }

    public SelenideElement getTextMessage() {
        return $(TEXT_MESSAGE).shouldBe(visible
                .because("Text message should be visible before clicking it"));
    }
}
