package mobile.tests;

import mobile.pages.ArticleDetailsPage;
import mobile.pages.MainPage;
import mobile.pages.OnboardingPage;
import mobile.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ArticleContentTest extends BaseMobileTest {

    @BeforeClass
    public void setupTest() throws InterruptedException {
        Thread.sleep(2000);
        OnboardingPage onboardingPage = new OnboardingPage(driver);
        onboardingPage.completeOnboarding();
        Thread.sleep(2000);
    }

    @Test(priority = 1, description = "Verify article content is displayed")
    public void testArticleContentDisplayed() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSearchContainer();

        Thread.sleep(1000);

        SearchPage searchPage = new SearchPage(driver);
        searchPage.enterSearchQuery("Computer Science");
        searchPage.clickFirstResult();

        ArticleDetailsPage articlePage = new ArticleDetailsPage(driver);
        Assert.assertTrue(articlePage.isArticleDisplayed(),
                "Article content should be displayed");
    }

    @Test(priority = 2, description = "Verify navigation back from article")
    public void testNavigationBackFromArticle() throws InterruptedException {
        driver.navigate().back();

        ArticleDetailsPage articlePage = new ArticleDetailsPage(driver);
        articlePage.clickBack();

        Thread.sleep(2000);

        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("search") ||
                        pageSource.contains("Search"),
                "Should navigate back to search");
    }
}
