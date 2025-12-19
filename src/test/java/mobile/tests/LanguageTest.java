package mobile.tests;

import mobile.pages.MainPage;
import mobile.pages.OnboardingPage;
import mobile.pages.SearchPage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LanguageTest extends BaseMobileTest {

    @BeforeClass
    public void setupTest() throws InterruptedException {
        Thread.sleep(2000);
        OnboardingPage onboardingPage = new OnboardingPage(driver);
        onboardingPage.completeOnboarding();
        Thread.sleep(2000);
    }

    @Test(priority = 1, description = "Verify language button is accessible")
    public void testLanguageButtonAccessible() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSearchContainer();

        Thread.sleep(1000);

        Assert.assertTrue(driver.getPageSource().contains("search") ||
                        driver.getPageSource().contains("Search"),
                "Should be on search page");
    }

    @Test(priority = 2, description = "Verify search works in default language")
    public void testSearchInDefaultLanguage() throws InterruptedException {
        driver.navigate().back();
        //Thread.sleep(1000);

        /*MainPage mainPage = new MainPage(driver);
        mainPage.clickSearchContainer();*/

        Thread.sleep(1000);

        SearchPage searchPage = new SearchPage(driver);
        searchPage.enterSearchQuery("Wikipedia");

        Thread.sleep(2000);

        Assert.assertTrue(searchPage.areResultsDisplayed(),
                "Search should work in default language");
        Assert.assertTrue(searchPage.getSearchResultsCount() > 0,
                "Should have search results");
    }
}
