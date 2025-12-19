package web.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.pages.ArticlePage;
import web.pages.HomePage;

public class ArticleTest extends BaseWebTest {

    private HomePage homePage;
    private ArticlePage articlePage;

    @BeforeMethod
    public void setUpTest() {
        navigateToHomePage();
        homePage = new HomePage(driver);
    }

    @Test(priority = 1, description = "Verify article page structure")
    public void testArticlePageStructure() throws InterruptedException {
        Thread.sleep(2000);
        homePage.searchFor("Wikipedia");
        articlePage = new ArticlePage(driver);
        Thread.sleep(2000);

        Assert.assertTrue(articlePage.isArticleTitleDisplayed(),
                "Article title should be displayed");
    }

    @Test(priority = 2, description = "Verify article has table of contents")
    public void testArticleTableOfContents() throws InterruptedException {
        Thread.sleep(2000);
        homePage.searchFor("Wikipedia");
        Thread.sleep(2000);
        articlePage = new ArticlePage(driver);

        Assert.assertTrue(articlePage.hasTableOfContents(),
                "Long articles should have table of contents");
    }

    @Test(priority = 3, description = "Verify article has categories")
    public void testArticleCategories() throws InterruptedException {
        Thread.sleep(2000);
        homePage.searchFor("Computer");
        Thread.sleep(2000);
        articlePage = new ArticlePage(driver);

        Assert.assertTrue(articlePage.hasCategoriesSection(),
                "Article should have categories section");
    }

    @Test(priority = 4, description = "Verify article has language links")
    public void testArticleLanguageLinks() throws InterruptedException {
        Thread.sleep(2000);
        homePage.searchFor("Technology");
        Thread.sleep(2000);
        articlePage = new ArticlePage(driver);

        Assert.assertTrue(articlePage.getLanguageLinksCount() > 0,
                "Article should have language links");
    }

    @Test(priority = 5, description = "Verify article title matches search")
    public void testArticleTitleMatchesSearch() throws InterruptedException {
        Thread.sleep(2000);
        String searchTerm = "Automation";
        homePage.searchFor(searchTerm);

        Thread.sleep(2000);

        articlePage = new ArticlePage(driver);
        String articleTitle = articlePage.getArticleTitle();

        Assert.assertTrue(articleTitle.toLowerCase().contains(searchTerm.toLowerCase()) ||
                        driver.getTitle().toLowerCase().contains(searchTerm.toLowerCase()),
                "Article title should be related to search term");
    }
}
