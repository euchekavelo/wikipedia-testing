package mobile.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BaseMobilePage {

    @AndroidFindBy(id = "search_src_text")
    private WebElement searchInput;

    @AndroidFindBy(id = "page_list_item_title")
    private List<WebElement> searchResults;

    @AndroidFindBy(id = "search_lang_button")
    private WebElement languageButton;

    public SearchPage(AppiumDriver driver) {
        super(driver);
    }

    public void enterSearchQuery(String query) {
        typeText(searchInput, query);
    }

    public int getSearchResultsCount() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return searchResults.size();
    }

    public void clickFirstResult() {
        if (!searchResults.isEmpty()) {
            clickElement(searchResults.get(0));
        }
    }

    public String getFirstResultTitle() {
        if (!searchResults.isEmpty()) {
            return searchResults.get(0).getText();
        }

        return "";
    }

    public boolean areResultsDisplayed() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return !searchResults.isEmpty();
    }
}
