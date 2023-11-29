package uitest.m4;

import Foundation.BasicHomeTestClass;
import Helper.DemoHelper;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributesTest extends BasicHomeTestClass {

    @Test
    public void isEnabledTest() {

        WebElement textAreaToEnable = homePage.textArea();
        Assert.assertFalse(textAreaToEnable.isEnabled());

        if(textAreaToEnable.isEnabled()) {
            textAreaToEnable.sendKeys("test keys");
        }

        WebElement checkBoxHowHeardAbout = homePage.checkboxHeardAbout();
        checkBoxHowHeardAbout.click();
        Assert.assertTrue(checkBoxHowHeardAbout.isSelected());

        if(textAreaToEnable.isEnabled()) {
            textAreaToEnable.sendKeys("test keys");
        }
        DemoHelper.pause();
    }

    @Test
    public void isDisplayedTest() {
        WebElement feedback = homePage.invalidFeedback().getFirst();
        Assert.assertFalse(feedback.isDisplayed());
        homePage.registerButton().click();
        Assert.assertTrue(feedback.isDisplayed());
    }
}
