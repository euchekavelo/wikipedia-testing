package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ArticlePage extends BasePage {

    @FindBy(id = "firstHeading")
    private WebElement articleTitle;

    @FindBy(css = "#mw-content-text p")
    private List<WebElement> paragraphs;

    @FindBy(css = "#vector-toc")
    private WebElement tableOfContents;

    @FindBy(css = "#catlinks")
    private WebElement categories;

    @FindBy(css = ".interlanguage-link")
    private List<WebElement> languageLinks;

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    public String getArticleTitle() {
        waitForElementVisible(articleTitle);
        return articleTitle.getText();
    }

    public boolean isArticleTitleDisplayed() {
        try {
            waitForElementVisible(articleTitle);
            return articleTitle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public int getParagraphsCount() {
        return paragraphs.size();
    }

    public boolean hasTableOfContents() {
        try {
            waitForElementVisible(tableOfContents);
            return tableOfContents.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasCategoriesSection() {
        try {
            return categories.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public int getLanguageLinksCount() {
        return languageLinks.size();
    }
}
