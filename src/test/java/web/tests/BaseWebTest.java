package web.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

import java.time.Duration;

public class BaseWebTest {

    protected WebDriver driver;
    protected String baseUrl;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);

        int implicitWait = ConfigReader.getIntProperty("web.implicit.wait");
        int pageLoadTimeout = ConfigReader.getIntProperty("web.page.load.timeout");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));

        baseUrl = ConfigReader.getProperty("web.base.url");
    }

    @AfterMethod
    public void afterEachTest() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void navigateToHomePage() {
        driver.get(baseUrl);
    }
}
