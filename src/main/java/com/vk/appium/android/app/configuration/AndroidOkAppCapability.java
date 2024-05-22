package com.vk.appium.android.app.configuration;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class AndroidOkAppCapability implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setPlatformVersion("13");
        options.setCapability("appium:automationName",
                AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName(""); //Enter Device Name
        options.setAppPackage("ru.ok.android");
        options.setAppActivity("ru.ok.android.ui.activity.main.OdklActivity");

        try {
            return new AndroidDriver(new URI("http://localhost:4723").toURL(), options);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
