package mobile.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.Capabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseMobileTest {

    protected AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        Capabilities capabilities = new UiAutomator2Options()
                .setPlatformName(ConfigReader.getProperty("mobile.platform.name"))
                .setDeviceName(ConfigReader.getProperty("mobile.device.name"))
                .setPlatformVersion(ConfigReader.getProperty("mobile.platform.version"))
                .setAppPackage(ConfigReader.getProperty("mobile.app.package"))
                .setAppActivity(ConfigReader.getProperty("mobile.app.activity"))
                .setAutomationName(ConfigReader.getProperty("mobile.automation.name"))
                .setAppWaitPackage(ConfigReader.getProperty("mobile.app.package"))
                .setNoReset(true)
                .setFullReset(false);

        driver = new AndroidDriver(new URL(ConfigReader.getProperty("mobile.appium.server")), capabilities);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.terminateApp(ConfigReader.getProperty("mobile.app.package"));
            driver.quit();
        }
    }
}
