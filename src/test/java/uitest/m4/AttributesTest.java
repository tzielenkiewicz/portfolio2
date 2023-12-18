package uitest.m4;

import Factory.CommonFunctions;
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
            homePage.fillTextArea("test keys");
        }

        WebElement checkBoxHowHeardAbout = homePage.checkboxHeardAbout();
        CommonFunctions.clickSpecifiedElement(checkBoxHowHeardAbout);
        Assert.assertTrue(checkBoxHowHeardAbout.isSelected());

        if(textAreaToEnable.isEnabled()) {
            homePage.fillTextArea("test keys");
        }
        DemoHelper.pause();
    }

    @Test
    public void isDisplayedTest() {
        WebElement feedback = homePage.invalidFeedback().getFirst();
        Assert.assertFalse(feedback.isDisplayed());
        CommonFunctions.clickSpecifiedElement(homePage.registerButton());
        Assert.assertTrue(feedback.isDisplayed());
    }
}
