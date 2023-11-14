package uitest.m4;

import Helper.DemoHelper;
import Helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Helper.Pages.HOME;

public class AttributesTest {

    @Test
    public void isEnabledTest() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);
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
        driver.quit();

    }

    @Test
    public void isDisplayedTest() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);
        WebElement feedback = driver.findElement(By.className("invalid-feedback"));

        Assert.assertFalse(feedback.isDisplayed());
        driver.findElement(By.id("register")).click();
        Assert.assertTrue(feedback.isDisplayed());

        driver.quit();
    }

}
