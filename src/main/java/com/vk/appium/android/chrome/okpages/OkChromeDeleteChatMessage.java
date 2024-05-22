package com.vk.appium.android.chrome.okpages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

public class OkChromeDeleteChatMessage extends OkChromeProfilePage {
    private static final By MESSAGE_ACTION_MORE_BUTTON = By.xpath(".//button[@data-l='t,messageActionMore']");
    private static final By MESSAGE_ACTION_REMOVE_BUTTON = By.xpath(".//msg-menu-item[@data-l='t,messageActionremove']");
    private static final By CONFIRM_DELETE_MESSAGE_BUTTON = By.xpath(".//button[@data-tsid='confirm-primary']");
    private static final By TEXT_MESSAGE = By.xpath(".//span[@data-tsid='message_text']");

    public OkChromeDeleteChatMessage() {
        super();
    }

    public void deleteChatMessage() {
        $(MESSAGE_ACTION_MORE_BUTTON).shouldBe(visible
                        .because("Message action more button should be visible before clicking it"))
                .click();
        $(MESSAGE_ACTION_REMOVE_BUTTON).shouldBe(visible
                        .because("Message action remove button should be visible before clicking it"))
                .click();
        $(CONFIRM_DELETE_MESSAGE_BUTTON).shouldBe(visible
                        .because("Confirm delete message button should be visible before clicking it"))
                .click();
        open(WebDriverRunner.url());
        refresh();
    }

    public SelenideElement getTextMessage() {
        return $(TEXT_MESSAGE);
    }
}
