package mobile.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class OnboardingPage extends BaseMobilePage {

    @AndroidFindBy(id = "primaryTextView")
    private WebElement primaryText;

    @AndroidFindBy(id = "fragment_onboarding_forward_button")
    private WebElement forwardButton;

    @AndroidFindBy(id = "fragment_onboarding_skip_button")
    private WebElement skipButton;

    @AndroidFindBy(id = "fragment_onboarding_done_button")
    private WebElement doneButton;

    public OnboardingPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickForward() {
        clickElement(forwardButton);
    }

    public void clickSkip() {
        if (isElementDisplayed(skipButton)) {
            clickElement(skipButton);
        }
    }

    public void clickDone() {
        if (isElementDisplayed(doneButton)) {
            clickElement(doneButton);
        }
    }

    public void completeOnboarding() {
        try {
            if (isElementDisplayed(skipButton)) {
                clickSkip();
            } else {
                for (int i = 0; i < 4; i++) {
                    if (isElementDisplayed(forwardButton)) {
                        clickForward();
                    } else if (isElementDisplayed(doneButton)) {
                        clickDone();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
