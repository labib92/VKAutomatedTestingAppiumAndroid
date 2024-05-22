package com.vk.appium.android.chrome.oktests;

import com.codeborne.selenide.Selenide;
import com.vk.appium.android.chrome.okpages.OkChromeBasePage;
import com.vk.appium.android.chrome.okpages.OkChromeCreateChat;
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

@DisplayName("Ok.ru Chrome send chat message test")
public class OkChromeSendChatMessageTest extends OkChromeBaseTest {
    private OkChromeCreateChat createChat;
    private OkChromeSendChatMessage sendChatMessage;

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
    @DisplayName("test send Labib's chat message")
    @Tag("SendLabibChatMessage")
    @Timeout(value = 40000, unit = TimeUnit.MILLISECONDS)
    public void testSendChatMessageSuccess(String chatName, String chatMessage) {
        createChat = new OkChromeCreateChat();
        sendChatMessage = new OkChromeSendChatMessage();
        createChat.createChat(chatName);
        sendChatMessage.sendChatMessage(chatMessage);
        Assertions.assertAll("Send labib's Chat",
                () -> Assertions.assertEquals(createChat.getChatTittle().getText(), chatName,
                        "Chat Tittle: " + chatName + " should be visible after successfully creating a chat"),
                () -> Assertions.assertEquals(sendChatMessage.getTextMessage().getText(), chatMessage,
                        "Send Message: " + chatMessage + " should be visible after sending a successful message"));
    }

    @DisplayName("Ok.ru Send another chat message test")
    @Nested
    class OkChromeSendAnotherChatMessageTest {

        @ParameterizedTest
        @CsvSource("Cat's Chat, Hello Fish!")
        @DisplayName("test send Cat's chat message")
        @Tag("SendCatChatMessage")
        @Timeout(value = 40000, unit = TimeUnit.MILLISECONDS)
        public void testSendAnotherChatMessageSuccess(String chatName, String chatMessage) {
            createChat = new OkChromeCreateChat();
            sendChatMessage = new OkChromeSendChatMessage();
            createChat.createChat(chatName);
            sendChatMessage.sendChatMessage(chatMessage);
            Assertions.assertAll("Send Cat's Chat",
                    () -> Assertions.assertEquals(createChat.getChatTittle().getText(), chatName,
                            "Chat Tittle: " + chatName + " should be visible after successfully creating a chat"),
                    () -> Assertions.assertEquals(sendChatMessage.getTextMessage().getText(), chatMessage,
                            "Send Message: " + chatMessage + " should be visible after sending a successful message"));
        }

        @DisplayName("Ok.ru Send final chat message test")
        @Nested
        class OkChromeSendFinalChatMessageTest {

            @ParameterizedTest
            @CsvSource("Dog's Chat, Hello Bones!")
            @DisplayName("test send Dog's chat message")
            @Tag("SendDogChatMessage")
            @Timeout(value = 40000, unit = TimeUnit.MILLISECONDS)
            public void testSendAnotherChatMessageSuccess(String chatName, String chatMessage) {
                createChat = new OkChromeCreateChat();
                sendChatMessage = new OkChromeSendChatMessage();
                createChat.createChat(chatName);
                sendChatMessage.sendChatMessage(chatMessage);
                Assertions.assertAll("Send Cat's Chat",
                        () -> Assertions.assertEquals(createChat.getChatTittle().getText(), chatName,
                                "Chat Tittle: " + chatName + " should be visible after successfully creating a chat"),
                        () -> Assertions.assertEquals(sendChatMessage.getTextMessage().getText(), chatMessage,
                                "Send Message: " + chatMessage + " should be visible after sending a successful message"));
            }

        }
    }

    private void getGoToProfilePage() {
        log.info("Go to Profile Page");
    }
}
