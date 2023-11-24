package uitest.m4;

import Foundation.BasicHomeTestClass;
import Helper.DemoHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributesTest extends BasicHomeTestClass {
    @Test
    public void isEnabledTest() {
        WebElement textAreaToEnable = chDriver.findElement(By.id("textarea"));
        Assert.assertFalse(textAreaToEnable.isEnabled());

        if(textAreaToEnable.isEnabled()) {
            textAreaToEnable.sendKeys("test keys");
        }

        WebElement heardAboutCheck = chDriver.findElement(By.id("heard-about"));
        heardAboutCheck.click();
        Assert.assertTrue(heardAboutCheck.isSelected());

        if(textAreaToEnable.isEnabled()) {
            textAreaToEnable.sendKeys("test keys");
        }
        DemoHelper.pause();
    }

    @Test
    public void isDisplayedTest() {
        WebElement feedback = chDriver.findElement(By.className("invalid-feedback"));

        Assert.assertFalse(feedback.isDisplayed());
        chDriver.findElement(By.id("register")).click();
        Assert.assertTrue(feedback.isDisplayed());
    }
}
