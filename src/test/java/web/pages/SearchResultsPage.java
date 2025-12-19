package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(css = ".mw-search-result-heading a")
    private List<WebElement> searchResults;

    @FindBy(css = ".searchresults")
    private WebElement searchResultsContainer;

    @FindBy(css = ".searchmatch")
    private List<WebElement> highlightedMatches;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public int getResultsCount() {
        waitForElementVisible(searchResultsContainer);
        return searchResults.size();
    }

    public void clickFirstResult() {
        waitForElementVisible(searchResultsContainer);
        if (!searchResults.isEmpty()) {
            clickElement(searchResults.get(0));
        }
    }

    public boolean areResultsDisplayed() {
        try {
            waitForElementVisible(searchResultsContainer);
            return !searchResults.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasHighlightedMatches() {
        return !highlightedMatches.isEmpty();
    }
}
