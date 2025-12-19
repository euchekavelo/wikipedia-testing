package web.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import web.pages.HomePage;
import web.pages.SearchResultsPage;

public class SearchTest extends BaseWebTest {

    private HomePage homePage;
    private SearchResultsPage searchResultsPage;

    @BeforeMethod
    public void setUpTest() {
        navigateToHomePage();
        homePage = new HomePage(driver);
    }

    @DataProvider(name = "searchTerms")
    public Object[][] searchTermsProvider() {
        return new Object[][] {{"Marcus name"}, {"Kirill name"}};
    }

    @Test(priority = 1, description = "Verify search functionality returns results")
    public void testSearchReturnsResults() throws InterruptedException {
        Thread.sleep(2000);
        homePage.searchFor("Masha name");
        searchResultsPage = new SearchResultsPage(driver);
        Thread.sleep(2000);

        Assert.assertTrue(searchResultsPage.areResultsDisplayed(),
                "Search results should be displayed");
        Assert.assertTrue(searchResultsPage.getResultsCount() > 0,
                "Should have at least one search result");
    }

    @Test(priority = 2, dataProvider = "searchTerms",
            description = "Verify search with multiple terms")
    public void testSearchWithMultipleTerms(String searchTerm) throws InterruptedException {
        Thread.sleep(2000);
        homePage.searchFor(searchTerm);
        searchResultsPage = new SearchResultsPage(driver);
        Thread.sleep(2000);

        Assert.assertTrue(searchResultsPage.areResultsDisplayed(),
                "Search results should be displayed for: " + searchTerm);
        Assert.assertTrue(searchResultsPage.getResultsCount() > 0,
                "Should have results for: " + searchTerm);
    }

    @Test(priority = 3, description = "Verify clicking on search result opens article")
    public void testClickSearchResult() throws InterruptedException {
        Thread.sleep(2000);
        homePage.searchFor("Tree name");
        Thread.sleep(2000);
        searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.clickFirstResult();
        Thread.sleep(2000);

        Assert.assertTrue(driver.getCurrentUrl().contains("wiki"),
                "Should navigate to article page");
        Assert.assertTrue(driver.getTitle().length() > 0,
                "Article page should have a title");
    }

    @Test(priority = 4, description = "Verify search highlights matching terms")
    public void testSearchHighlighting() throws InterruptedException {
        Thread.sleep(2000);
        homePage.searchFor("Tree name");
        searchResultsPage = new SearchResultsPage(driver);
        Thread.sleep(2000);

        Assert.assertTrue(searchResultsPage.hasHighlightedMatches(),
                "Search terms should be highlighted in results");
    }
}
