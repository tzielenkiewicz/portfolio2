package uitest.m4;

import Helper.DemoHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Factory.DriverFactory.initDriver;

public class AttributesTest {
    WebDriver driver;
    @BeforeMethod
    public void driverInitiation() {
        initDriver(driver);
    }
    @Test
    public void isEnabledTest() {
        WebElement textAreaToEnable = driver.findElement(By.id("textarea"));
        Assert.assertFalse(textAreaToEnable.isEnabled());

        if(textAreaToEnable.isEnabled()) {
            textAreaToEnable.sendKeys("test keys");
        }

        WebElement heardAboutCheck = driver.findElement(By.id("heard-about"));
        heardAboutCheck.click();
        Assert.assertTrue(heardAboutCheck.isSelected());

        if(textAreaToEnable.isEnabled()) {
            textAreaToEnable.sendKeys("test keys");
        }
        DemoHelper.pause();
    }

    @Test
    public void isDisplayedTest() {
        WebElement feedback = driver.findElement(By.className("invalid-feedback"));

        Assert.assertFalse(feedback.isDisplayed());
        driver.findElement(By.id("register")).click();
        Assert.assertTrue(feedback.isDisplayed());
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }

}
