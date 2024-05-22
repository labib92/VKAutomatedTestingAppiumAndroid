package com.vk.appium.android.chrome.oktests;

import com.codeborne.selenide.Selenide;
import com.vk.appium.android.chrome.okpages.OkChromeBasePage;
import com.vk.appium.android.chrome.okpages.OkChromeCreateChat;
import com.vk.appium.android.chrome.okpages.OkChromeLoginPage;
import com.vk.appium.android.chrome.okpages.OkChromeLogout;
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

@DisplayName("Ok.ru Chrome Create Chat Test")
public class OkChromeCreateChatTest extends OkChromeBaseTest {
    private OkChromeCreateChat createChat;

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
    @CsvSource("Labib's Chat")
    @DisplayName("test create Labib's chat")
    @Tag("createLabibChat")
    @Timeout(value = 40000, unit = TimeUnit.MILLISECONDS)
    public void testCreateChatSuccess(String chatName) {
        createChat = new OkChromeCreateChat();
        createChat.createChat(chatName);
        Assertions.assertEquals(createChat.getChatTittle().getText(), chatName,
                "Chat Tittle: " + chatName + " should be visible after successfully creating a chat");
    }

    @DisplayName("Ok.ru Chrome Create Another Chat Test")
    @Nested
    class OkChromeCreateAnotherChat {

        @ParameterizedTest
        @CsvSource("Labib's Music Chat")
        @DisplayName("test create Music chat")
        @Tag("createMusicChat")
        @Timeout(value = 40000, unit = TimeUnit.MILLISECONDS)
        public void testCreateAnotherChatSuccess(String chatName) {
            createChat = new OkChromeCreateChat();
            createChat.createChat(chatName);
            Assertions.assertEquals(createChat.getChatTittle().getText(), chatName,
                    "Chat Tittle: " + chatName + " should be visible after successfully creating a chat");
        }
    }

    private void getGoToProfilePage() {
        log.info("Go to Profile Page");
    }
}
