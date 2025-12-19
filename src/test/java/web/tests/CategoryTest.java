package web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import web.pages.CategoryPage;

public class CategoryTest extends BaseWebTest {

    @Test(priority = 1, description = "Verify category page displays items")
    public void testCategoryPageDisplaysItems() throws InterruptedException {
        //Thread.sleep(2000);
        driver.get(baseUrl + "/wiki/Category:Technology");
        CategoryPage categoryPage = new CategoryPage(driver);
        //Thread.sleep(2000);

        Assert.assertTrue(categoryPage.getCategoryTitle().contains("Category"),
                "Should be on a category page");
        Assert.assertTrue(categoryPage.getCategoryItemsCount() > 0,
                "Category should have items");
    }

    @Test(priority = 2, description = "Verify category navigation")
    public void testCategoryNavigation() throws InterruptedException {
        //Thread.sleep(2000);
        driver.get(baseUrl + "/wiki/Category:Science");
        CategoryPage categoryPage = new CategoryPage(driver);
        String initialUrl = driver.getCurrentUrl();
        categoryPage.clickFirstItem();
        //Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), initialUrl,
                "Should navigate to different page");
    }
}
