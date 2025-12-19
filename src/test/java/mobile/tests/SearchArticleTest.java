package mobile.tests;

import mobile.pages.MainPage;
import mobile.pages.OnboardingPage;
import mobile.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchArticleTest extends BaseMobileTest{

    @BeforeClass
    public void setupTest() throws InterruptedException {
        Thread.sleep(2000);
        OnboardingPage onboardingPage = new OnboardingPage(driver);
        onboardingPage.completeOnboarding();
        Thread.sleep(2000);
    }

    @DataProvider(name = "searchQueries")
    public Object[][] searchQueriesProvider() {
        return new Object[][] {
                {"Petya name"},
                {"Rustam name"}
        };
    }

    @Test(priority = 1, description = "Verify search functionality")
    public void testSearchArticle() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSearchContainer();

        Thread.sleep(1000);

        SearchPage searchPage = new SearchPage(driver);
        searchPage.enterSearchQuery("Selenium");

        Assert.assertTrue(searchPage.areResultsDisplayed(),
                "Search results should be displayed");
        Assert.assertTrue(searchPage.getSearchResultsCount() > 0,
                "Should have at least one search result");
    }

    @Test(priority = 2, dataProvider = "searchQueries",
            description = "Verify search with multiple queries")
    public void testSearchWithMultipleQueries(String query) throws InterruptedException {
        Thread.sleep(2000);

        SearchPage searchPage = new SearchPage(driver);
        searchPage.enterSearchQuery(query);

        Thread.sleep(2000);

        Assert.assertTrue(searchPage.areResultsDisplayed(),
                "Search results should be displayed for: " + query);
    }

    @Test(priority = 3, description = "Verify opening article from search")
    public void testOpenArticleFromSearch() throws InterruptedException {
        Thread.sleep(1000);

        SearchPage searchPage = new SearchPage(driver);
        searchPage.enterSearchQuery("Java programming");

        Thread.sleep(2000);

        String firstResultTitle = searchPage.getFirstResultTitle();
        Assert.assertFalse(firstResultTitle.isEmpty(), "First result should have a title");

        searchPage.clickFirstResult();
        Thread.sleep(3000);

        String pageSource = driver.getPageSource();
        Assert.assertFalse(pageSource.isEmpty(), "Article page should load");
    }
}
