package com.vk.appium.android.app.oktests;

import com.codeborne.selenide.Selenide;
import com.vk.appium.android.app.okpages.OkAppCreateChat;
import com.vk.appium.android.app.okpages.OkAppSendChatMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.concurrent.TimeUnit;

@DisplayName("Ok App Send Chat Message Class")
public class OkAppSendChatMessageTest extends OkAppBaseTest {
    private OkAppSendChatMessage sendChatMessage;
    private OkAppCreateChat createChat;

    @AfterEach
    @Override
    public void tearDown() {
        log.info("Deleting Chat");
        createChat.deleteChat();
        log.info("Closing the Ok App");
        Selenide.closeWebDriver();
    }

    @ParameterizedTest
    @CsvSource("Labib's chat, Hello World!, I am a LABIB.")
    @DisplayName("Test Send Chat Message 1")
    @Tag("SendMessage")
    @Timeout(value = 40000, unit = TimeUnit.MILLISECONDS)
    public void testSendChatMessageSuccess(String chatName, String chatMessage, String message) {
        createChat = new OkAppCreateChat();
        chatLogInfo(chatName, chatMessage);
        createChat.createChat(chatName, chatMessage);
        sendChatMessage = new OkAppSendChatMessage();
        sendMessageLogInfo(message);
        sendChatMessage.sendChatMessage(message);
        Assertions.assertAll("Send Chat Message Success",
                () -> Assertions.assertEquals(sendChatMessage.getChatTittleMessageText(), chatName,
                        "Chat tittle should be " + chatName + " after creating chat."),
                () -> Assertions.assertEquals(sendChatMessage.getMessageText(chatMessage), chatMessage,
                        "Chat message should be " + chatMessage + " after sending chat message."),
                () -> Assertions.assertEquals(sendChatMessage.getMessageText(message), message,
                        "Message should be " + message + " after sending a message in chat."));
    }

    @DisplayName("Ok App Send New Chat Message Nested Class")
    @Nested
    class OkAppSendChatNewMessage {

        @ParameterizedTest
        @CsvSource("Cat's chat, Hello Fish!, I am a CAT.")
        @DisplayName("Test Send Chat New Message")
        @Tag("SendNewMessage")
        @Timeout(value = 40000, unit = TimeUnit.MILLISECONDS)
        public void testSendNewMessageSuccess(String chatName, String chatMessage, String anotherMessage) {
            createChat = new OkAppCreateChat();
            chatLogInfo(chatName, chatMessage);
            createChat.createChat(chatName, chatMessage);
            sendChatMessage = new OkAppSendChatMessage();
            sendMessageLogInfo(anotherMessage);
            sendChatMessage.sendChatMessage(anotherMessage);
            Assertions.assertAll("Send Chat Message Success",
                    () -> Assertions.assertEquals(sendChatMessage.getChatTittleMessageText(), chatName,
                            "Chat tittle should be " + chatName + " after creating chat."),
                    () -> Assertions.assertEquals(sendChatMessage.getMessageText(chatMessage), chatMessage,
                            "Chat message should be " + chatMessage + " after sending chat message."),
                    () -> Assertions.assertEquals(sendChatMessage.getMessageText(anotherMessage), anotherMessage,
                            "Message should be " + anotherMessage + " after sending a message in chat."));
        }

        @DisplayName("Ok App Send Final Chat Message Nested Class")
        @Nested
        class OkAppChatFinalMessage {

            @ParameterizedTest
            @CsvSource("Dog's chat, Hello Bones!, I am a DOG.")
            @DisplayName("Test Send Chat Final Message")
            @Tag("SendFinalMessage")
            @Timeout(value = 40000, unit = TimeUnit.MILLISECONDS)
            public void testSendFinalMessageSuccess(String chatName, String chatMessage, String finalMessage) {
                createChat = new OkAppCreateChat();
                chatLogInfo(chatName, chatMessage);
                createChat.createChat(chatName, chatMessage);
                sendChatMessage = new OkAppSendChatMessage();
                sendMessageLogInfo(finalMessage);
                sendChatMessage.sendChatMessage(finalMessage);
                Assertions.assertAll("Send Chat Message Success",
                        () -> Assertions.assertEquals(sendChatMessage.getChatTittleMessageText(), chatName,
                                "Chat tittle should be " + chatName + " after creating chat."),
                        () -> Assertions.assertEquals(sendChatMessage.getMessageText(chatMessage), chatMessage,
                                "Chat message should be " + chatMessage + " after sending chat message."),
                        () -> Assertions.assertEquals(sendChatMessage.getMessageText(finalMessage), finalMessage,
                                "Message should be " + finalMessage + " after sending a message in chat."));
            }
        }
    }

    private void chatLogInfo(String chatName, String chatMessage) {
        log.info("Creating chat {} and sending {}", chatName, chatMessage);
    }

    private void sendMessageLogInfo(String message) {
        log.info("Sending message {}", message);
    }
}
