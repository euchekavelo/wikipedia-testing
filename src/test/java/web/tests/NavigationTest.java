package web.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.pages.HomePage;

public class NavigationTest extends BaseWebTest {

    private HomePage homePage;

    @BeforeMethod
    public void setUpTest() {
        navigateToHomePage();
        homePage = new HomePage(driver);
    }

    @Test(priority = 1, description = "Verify home page loads successfully")
    public void testHomePageLoads() {
        Assert.assertTrue(homePage.isLogoDisplayed(), "Wikipedia logo should be displayed");
        Assert.assertTrue(homePage.isSearchInputDisplayed(), "Search input should be displayed");
        Assert.assertTrue(driver.getTitle().contains("Wikipedia"), "Page title should contain Wikipedia");
    }

    @Test(priority = 2, description = "Verify navigation to Contents page")
    public void testNavigateToContents() {
        homePage.clickContents();
        Assert.assertTrue(driver.getCurrentUrl().contains("Contents") ||
                        driver.getTitle().contains("Contents"),
                "Should navigate to Contents page");
    }

    @Test(priority = 3, description = "Verify navigation to Current Events")
    public void testNavigateToCurrentEvents() {
        homePage.clickCurrentEvents();
        Assert.assertTrue(driver.getCurrentUrl().contains("Current_events") ||
                        driver.getTitle().contains("Current events"),
                "Should navigate to Current Events page");
    }

    @Test(priority = 4, description = "Verify random article navigation")
    public void testRandomArticle() throws InterruptedException {
        String initialUrl = driver.getCurrentUrl();
        homePage.clickRandomArticle();

        //Thread.sleep(3000);

        String newUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(initialUrl, newUrl, "Should navigate to a different page");
        Assert.assertTrue(driver.getTitle().length() > 0, "Random article should have a title");
    }
}
