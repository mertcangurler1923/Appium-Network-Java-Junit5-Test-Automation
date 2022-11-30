package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {
    AndroidDriver driver;
    Log log=new Log();
    @BeforeAll
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:appPackage", "mobi.appcent.network");
        desiredCapabilities.setCapability("appium:appActivity", "mobi.appcent.network.activity.MainActivity");
        desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        log.info("Application started.");
        driver=new AndroidDriver <MobileElement>(remoteUrl,desiredCapabilities);
    }
    @AfterAll
    public void tearDown(){
        driver.quit();
    }
}
