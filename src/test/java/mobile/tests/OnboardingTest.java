package mobile.tests;

import mobile.pages.MainPage;
import mobile.pages.OnboardingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OnboardingTest extends BaseMobileTest {

    @Test(priority = 1, description = "Verify app launches and completes onboarding")
    public void testAppLaunchAndOnboarding() throws InterruptedException {
        Thread.sleep(3000);
        OnboardingPage onboardingPage = new OnboardingPage(driver);
        onboardingPage.completeOnboarding();

        Thread.sleep(2000);
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isMainPageDisplayed(),
                "Main page should be displayed after onboarding");
    }

    @Test(priority = 2, description = "Verify main page elements are displayed")
    public void testMainPageElements() throws InterruptedException {
        Thread.sleep(2000);

        OnboardingPage onboardingPage = new OnboardingPage(driver);
        onboardingPage.completeOnboarding();

        Thread.sleep(2000);

        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isSearchContainerDisplayed(),
                "Search container should be displayed");
    }
}
