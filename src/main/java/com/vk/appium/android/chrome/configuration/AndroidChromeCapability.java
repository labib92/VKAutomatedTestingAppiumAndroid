package com.vk.appium.android.chrome.configuration;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class AndroidChromeCapability implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("appium:automationName",
                AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName("Android");
        options.setAndroidDeviceSerialNumber(""); //Enter Device name
        options.setBrowserVersion("106");

        try {
            return new AndroidDriver(new URI("http://localhost:4723").toURL(), options);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
