package web.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "searchInput")
    private WebElement searchInput;

    @FindBy(id = "n-randompage")
    private WebElement randomArticleLink;

    @FindBy(id = "vector-main-menu-dropdown-checkbox")
    private WebElement dropMainMenu;

    @FindBy(linkText = "Contents")
    private WebElement contentsLink;

    @FindBy(className = "mw-logo-icon")
    private WebElement logo;

    @FindBy(id = "n-currentevents")
    private WebElement currentEventsLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchFor(String searchTerm) {
        typeText(searchInput, searchTerm);
        searchInput.sendKeys(Keys.ENTER);
    }

    public void clickRandomArticle() {
        dropMainMenu.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        clickElement(randomArticleLink);
    }

    public void clickContents() {
        dropMainMenu.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        clickElement(contentsLink);
    }

    public void clickCurrentEvents() {
        dropMainMenu.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        clickElement(currentEventsLink);
    }

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    public boolean isSearchInputDisplayed() {
        return searchInput.isDisplayed();
    }
}
