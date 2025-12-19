package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoryPage extends BasePage {

    @FindBy(id = "firstHeading")
    private WebElement categoryTitle;

    @FindBy(css = ".mw-category-group ul li a")
    private List<WebElement> categoryItems;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public String getCategoryTitle() {
        waitForElementVisible(categoryTitle);
        return categoryTitle.getText();
    }

    public int getCategoryItemsCount() {
        return categoryItems.size();
    }

    public void clickFirstItem() {
        if (!categoryItems.isEmpty()) {
            clickElement(categoryItems.get(0));
        }
    }
}
