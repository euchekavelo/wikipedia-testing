package mobile.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ArticleDetailsPage extends BaseMobilePage {

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Navigate up']")
    private WebElement backButton;

    @AndroidFindBy(className = "android.webkit.WebView")
    private WebElement webView;

    public ArticleDetailsPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isArticleDisplayed() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return isElementDisplayed(webView);
    }

    public void clickBack() {
        if (isElementDisplayed(backButton)) {
            clickElement(backButton);
        }
    }
}
