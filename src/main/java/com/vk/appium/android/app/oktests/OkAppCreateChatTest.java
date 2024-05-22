package com.vk.appium.android.app.oktests;

import com.codeborne.selenide.Selenide;
import com.vk.appium.android.app.okpages.OkAppCreateChat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.concurrent.TimeUnit;

@DisplayName("Ok App Create Chat Class Test")
public class OkAppCreateChatTest extends OkAppBaseTest {
    private OkAppCreateChat okAppCreateChat;

    @AfterEach
    @Override
    public void tearDown() {
        log.info("Deleting Chat");
        okAppCreateChat.deleteChat();
        log.info("Closing the Ok App");
        Selenide.closeWebDriver();
    }

    @ParameterizedTest
    @CsvSource({"Labib's chat, Hello World!.", "Vk's music chat, I love vk music."})
    @DisplayName("Test Create Chat")
    @Tag("CreateChat")
    @Timeout(value = 40000, unit = TimeUnit.MILLISECONDS)
    public void testCreateChatSuccess(String chatTittle, String message) {
        okAppCreateChat = new OkAppCreateChat();
        log.info("Creating Chat tittle {} and Chat message {}", chatTittle, message);
        okAppCreateChat.createChat(chatTittle, message);
        Assertions.assertAll("Create Chat",
                () -> Assertions.assertEquals(okAppCreateChat.getChatTittleText(), chatTittle,
                        "The chat tittle should be equal to " + chatTittle +
                                " after successfully creating a chat."),
                () -> Assertions.assertEquals(okAppCreateChat.getMessageText(), message,
                        "The chat message should be equal to " + message +
                                " after successfully creating a chat."));
    }
}
