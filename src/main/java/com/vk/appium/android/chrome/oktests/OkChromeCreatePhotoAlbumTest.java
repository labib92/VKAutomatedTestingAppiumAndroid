package com.vk.appium.android.chrome.oktests;

import com.codeborne.selenide.Selenide;
import com.vk.appium.android.chrome.okpages.OkChromeLogout;
import com.vk.appium.android.chrome.patterns.decorator.OkChromeCreateAlbumDecorator;
import com.vk.appium.android.chrome.patterns.decorator.OkChromeCreatePhotoAlbum;
import com.vk.appium.android.chrome.patterns.decorator.OkChromeCreatePhotoAlbumDecorator;
import com.vk.appium.android.chrome.patterns.decorator.OkChromeCreatePlainGroup;
import com.vk.appium.android.chrome.okpages.OkChromeBasePage;
import com.vk.appium.android.chrome.okpages.OkChromeLoginPage;
import com.vk.appium.android.chrome.patterns.decorator.OkChromeCreateSharedPhotoAlbumDecorator;
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

@DisplayName("Ok.ru Chrome create photo album test")
public class OkChromeCreatePhotoAlbumTest extends OkChromeBaseTest {
    private OkChromeCreatePhotoAlbum photoAlbum;

    @AfterEach
    @Override
    public void tearDown() {
        log.info("Deleting the album");
        photoAlbum.deletePhotoAlbum();
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

    @ParameterizedTest
    @CsvSource("Labib's Photo Album")
    @DisplayName("test create photo album")
    @Tag("createPhotoAlbum")
    @Timeout(value = 40000, unit = TimeUnit.MILLISECONDS)
    public void testCreatePhotoAlbumSuccess(String albumName) {
        photoAlbum = new OkChromeCreatePhotoAlbumDecorator(new
                OkChromeCreateAlbumDecorator(new OkChromeCreatePlainGroup()), albumName);
        log.info("create album {} ", albumName);
        photoAlbum.createPhotoAlbum();
        Assertions.assertEquals(photoAlbum.getAlbumName().getText(), albumName,
                "Photo album " + albumName + " should be visible after creating a regular album");
    }

    @DisplayName("Ok.ru Chrome shared photo album test")
    @Nested
    class OkChromeCreateSharedAlbumTest {

        @ParameterizedTest
        @CsvSource("Labib's Shared Album")
        @DisplayName("test create shared photo")
        @Tag("createSharedPhotoAlbum")
        @Timeout(value = 40000, unit = TimeUnit.MILLISECONDS)
        public void testCreateSharedPhotoAlbumSuccess(String albumName) {
            photoAlbum = new OkChromeCreateSharedPhotoAlbumDecorator(
                    new OkChromeCreateAlbumDecorator(new OkChromeCreatePlainGroup()), albumName);
            photoAlbum.createPhotoAlbum();
            Assertions.assertEquals(photoAlbum.getAlbumName().getText(), albumName,
                    "Shared photo album " + albumName + " should be visible after creating " +
                            "shared album");
        }
    }

    private void getGoToProfilePage() {
        log.info("Go to Profile Page");
    }
}
