package mobile.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class MainPage extends BaseMobilePage {

    @AndroidFindBy(id = "search_container")
    private WebElement searchContainer;

    public MainPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isMainPageDisplayed() {
        return isElementDisplayed(searchContainer);
    }

    public void clickSearchContainer() {
        clickElement(searchContainer);
    }

    public boolean isSearchContainerDisplayed() {
        return isElementDisplayed(searchContainer);
    }
}
