package com.vk.appium.android.chrome.okpages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class OkChromeCreateChat extends OkChromeProfilePage {
    private static final By MESSAGE_TOOLBAR = By.xpath(".//a[@title='Messages']");
    private static final By CREATE_CHAT_BUTTON = By.xpath(".//button[@data-l='t,createChat']");
    private static final By CHAT_NAME= By.xpath(".//div[@data-tsid='chat-theme-input']");
    private static final By CREATE_AN_EMPTY_CHAT = By.xpath(".//button[@class='primary-okmsg']");
    private static final By CHAT_TITTLE = By.xpath(".//msg-parsed-text[@emoji-context='chat-title']");
    private static final By SHOW_CHAT_INFO_BUTTON_SAMSUNG_DEX = By.xpath(".//msg-menu-item[@data-l='t,showChatInfo']");
    private static final By SHOW_CHAT_INFO_BUTTON_ANDROID_MOBILE = By.xpath(".//button[@data-l='t,showChatInfo']");
    private static final By REMOVE_CHAT = By.xpath(".//msg-l10n[@key='remove-chat']");
    private static final By CONFIRM_DELETE_BUTTON = By.xpath(".//button[@data-tsid='confirm-primary']");
    private static final By MORE_BUTTON = By.xpath(".//button[@slot='element']");


    public OkChromeCreateChat(){
        super();
    }

    public void createChat(String chatName){
        $(MESSAGE_TOOLBAR).shouldBe(visible
                .because("Message toolbar should be visible before click it"))
                .click();
        $(CREATE_CHAT_BUTTON).shouldBe(visible
                .because("Create chat button should be visible before click it"))
                .click();
        $(CHAT_NAME).shouldBe(visible
                        .because("Chat name should be visible before typing the text"))
                .type(chatName);
        SelenideElement element = $(CREATE_AN_EMPTY_CHAT);
        $(CREATE_AN_EMPTY_CHAT).should(exist
                .because("Create an empty chat should be exist before click it"));
        executeJavaScript("arguments[0].click();", element);
    }

    public void deleteChat(){
        if($(MORE_BUTTON).isDisplayed()){
            SelenideElement moreButton = $(MORE_BUTTON);
            executeJavaScript("arguments[0].click();" , moreButton);
            SelenideElement chatInfo = $(SHOW_CHAT_INFO_BUTTON_SAMSUNG_DEX).should(exist
                    .because("Chat info Samsung Dex should exist"));
            executeJavaScript("arguments[0].click();" , chatInfo);
        }else {
            SelenideElement chatInfo = $(SHOW_CHAT_INFO_BUTTON_ANDROID_MOBILE).should(exist
                    .because("Chat info Samsung Android mobile should exist"));
            executeJavaScript("arguments[0].click();" , chatInfo);
        }
        SelenideElement removeChat = $(REMOVE_CHAT).should(exist
                .because("Remove should exist before clicking it"));
        executeJavaScript("arguments[0].click();" , removeChat);
        $(CONFIRM_DELETE_BUTTON).shouldBe(visible
                .because("Confirm delete button should be visible before clicking it"))
                .click();
    }

    public SelenideElement getChatTittle(){
        return $(CHAT_TITTLE).shouldBe(visible
                .because("Chat Tittle should be visible"));
    }
}
