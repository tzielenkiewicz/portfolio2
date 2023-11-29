package uitest.m9.pom;

import Foundation.BasicTestClass;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Home;

import java.util.List;

public class PomAbstractionLevelOneTest extends BasicTestClass {

    @Test
    public void homePageTest() {
        Home homePage = Home.createHomePage(chDriver);

        homePage.navigateTo();
        homePage.firstName().sendKeys("John");
        homePage.lastName().sendKeys("");
        homePage.registerButton().click();

        List<WebElement> feedbackResponses = homePage.invalidFeedback();
        Assert.assertFalse(feedbackResponses.get(0).isDisplayed());
        Assert.assertTrue(feedbackResponses.get(1).isDisplayed());
        Assert.assertEquals(feedbackResponses.get(1).getText(), "Valid last name is required");
    }
}
