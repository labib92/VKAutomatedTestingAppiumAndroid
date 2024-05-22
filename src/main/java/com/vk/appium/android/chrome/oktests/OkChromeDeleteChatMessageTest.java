package com.vk.appium.android.chrome.oktests;

import com.codeborne.selenide.Selenide;
import com.vk.appium.android.chrome.okpages.OkChromeBasePage;
import com.vk.appium.android.chrome.okpages.OkChromeCreateChat;
import com.vk.appium.android.chrome.okpages.OkChromeDeleteChatMessage;
import com.vk.appium.android.chrome.okpages.OkChromeLoginPage;
import com.vk.appium.android.chrome.okpages.OkChromeLogout;
import com.vk.appium.android.chrome.okpages.OkChromeSendChatMessage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

@DisplayName("Ok.ru Chrome delete chat message test")
public class OkChromeDeleteChatMessageTest extends OkChromeBaseTest {
    private OkChromeCreateChat createChat;
    private OkChromeSendChatMessage sendChatMessage;
    private OkChromeDeleteChatMessage deleteChatMessage;

    @BeforeEach
    @Override
    public void setup() {
        log.info("Setup Ok Test");
        log.info("Open m.ok.ru");
        open("/");
        okLoginPage = new OkChromeLoginPage();
        okLoginPage.login();
        log.info("Input username {}", username);
        okLoginPage.username(username);
        log.info("Input password {}", password);
        okLoginPage.password(password);
        log.info("Press submit button");
        okLoginPage.submit();
        getGoToProfilePage();
        OkChromeBasePage page = new OkChromeBasePage();
        page.goToProfilePage();
    }

    @AfterEach
    @Override
    public void tearDown() {
        log.info("Delete chat");
        createChat.deleteChat();
        OkChromeBasePage basePage = new OkChromeBasePage();
        log.info("Clicking on Message Toolbar");
        basePage.clickNewsFeedToolbar();
        getGoToProfilePage();
        basePage.goToProfilePage();
        OkChromeLogout logout = new OkChromeLogout();
        log.info("Starting Logout");
        logout.logoutSuccess();
    }

    @AfterAll
    public static void close() {
        log.info("Closing the browser");
        Selenide.closeWindow();
    }

    @ParameterizedTest
    @CsvSource("Labib's Chat, Hello World!")
    @DisplayName("test delete Labib's chat message")
    @Tag("DeleteLabibChatMessage")
    @Timeout(value = 40000, unit = TimeUnit.MILLISECONDS)
    public void testSendChatMessageSuccess(String chatName, String chatMessage) {
        createChat = new OkChromeCreateChat();
        sendChatMessage = new OkChromeSendChatMessage();
        deleteChatMessage = new OkChromeDeleteChatMessage();
        createChat.createChat(chatName);
        sendChatMessage.sendChatMessage(chatMessage);
        deleteChatMessage.deleteChatMessage();
        Assertions.assertFalse(deleteChatMessage.getTextMessage().isDisplayed(),
                "Chat message: " + chatMessage + " should not exist after deleting chat text message");
    }

    @DisplayName("Ok.ru Delete another chat message test")
    @Nested
    class OkChromeDeleteAnotherChatMessageTest {

        @ParameterizedTest
        @CsvSource("Cat's Chat, Hello Fish!")
        @DisplayName("test delete Cat's chat message")
        @Tag("DeleteCatChatMessage")
        @Timeout(value = 40000, unit = TimeUnit.MILLISECONDS)
        public void testSendAnotherChatMessageSuccess(String chatName, String chatMessage) {
            createChat = new OkChromeCreateChat();
            sendChatMessage = new OkChromeSendChatMessage();
            deleteChatMessage = new OkChromeDeleteChatMessage();
            createChat.createChat(chatName);
            sendChatMessage.sendChatMessage(chatMessage);
            deleteChatMessage.deleteChatMessage();
            Assertions.assertFalse(deleteChatMessage.getTextMessage().isDisplayed(),
                    "Chat message: " + chatMessage + " should not exist after deleting chat text message");

        }

        @DisplayName("Ok.ru Delete final chat message test")
        @Nested
        class OkChromeSendFinalChatMessageTest {

            @ParameterizedTest
            @CsvSource("Dog's Chat, Hello Bones!")
            @DisplayName("test delete Dog's chat message")
            @Tag("DeleteDogChatMessage")
            @Timeout(value = 40000, unit = TimeUnit.MILLISECONDS)
            public void testSendAnotherChatMessageSuccess(String chatName, String chatMessage) {
                createChat = new OkChromeCreateChat();
                sendChatMessage = new OkChromeSendChatMessage();
                deleteChatMessage = new OkChromeDeleteChatMessage();
                createChat.createChat(chatName);
                sendChatMessage.sendChatMessage(chatMessage);
                deleteChatMessage.deleteChatMessage();
                Assertions.assertFalse(deleteChatMessage.getTextMessage().isDisplayed(),
                        "Chat message: " + chatMessage + " should not exist after deleting chat text message");
            }

        }
    }

    private void getGoToProfilePage() {
        log.info("Go to Profile Page");
    }
}
