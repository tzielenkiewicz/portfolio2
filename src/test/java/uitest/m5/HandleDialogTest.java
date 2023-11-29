package uitest.m5;

import Foundation.BasicHomeTestClass;
import Helper.DemoHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleDialogTest extends BasicHomeTestClass {
    @Test
    public void dismissAlertTest() {
        WebElement firstName = homePage.firstName();
        WebElement lastName = homePage.lastName();
        firstName.sendKeys("John");
        lastName.sendKeys("Smith");
        DemoHelper.pause();

        homePage.clearButton().click();
        DemoHelper.pause();

        Alert alertPopup = homePage.switchToAlert();
        alertPopup.dismiss();

        Assert.assertEquals(firstName.getAttribute("value"), "John");
        Assert.assertEquals(lastName.getAttribute("value"), "Smith");

        homePage.refreshSite();

        homePage.clearButton().click();
        DemoHelper.pause();

        alertPopup.accept();
    }
}
