package uitest.m9;

import Factory.DriverFactory;
import Wait.WaitingUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Helper.Pages.LOANS;

public class RefactorSetupCleanupTest {
    WebDriver chDriver;

    @BeforeMethod
    public void initDriver() {
        chDriver = DriverFactory.createdNewChromeDriver();
    }

    @Test
    public void refactoredTest() {
        chDriver.get(LOANS);
        chDriver.findElement(By.id("borrow")).sendKeys("500");

        WebElement messageReturned = WaitingUtils.waitUntilVisible(chDriver, By.id("result"), 6);
        Assert.assertEquals(messageReturned.getText(), "You will pays us back 1000");
    }

    @Test
    public void refactoredTestDuplicated() {
        chDriver.get(LOANS);
        chDriver.findElement(By.id("borrow")).sendKeys("100");

        WebElement messageReturned = WaitingUtils.waitUntilVisible(chDriver, By.id("result"), 6);
        Assert.assertEquals(messageReturned.getText(), "You will pays us back 200");
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        chDriver.quit();
    }
}
