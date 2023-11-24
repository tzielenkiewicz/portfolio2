package uitest.m9.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;

import java.util.List;

public class PomAbstractionLevelOneTest {
    WebDriver driver;

    @BeforeMethod
    public void initDriver() {
        driver = new ChromeDriver();
    }

    @Test
    public void homePageTest() {
        Home home = Home.homePage(driver);

        home.navigateTo();
        home.firstName().sendKeys("John");
        home.lastName().sendKeys("");
        home.registerButton().click();

        List<WebElement> feedbackResponses = home.invalidFeedback();
        Assert.assertFalse(feedbackResponses.get(0).isDisplayed());
        Assert.assertTrue(feedbackResponses.get(1).isDisplayed());
        Assert.assertEquals(feedbackResponses.get(1).getText(), "Valid last name is required");
    }

    @AfterMethod
    public void cleanup() {driver.quit();}
}
