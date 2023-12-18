package uitest.m5;

import Foundation.BasicHomeTestClass;
import Helper.DemoHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleDialogTest extends BasicHomeTestClass {
    @Test
    public void dismissAlertTest() {
        homePage.fillInputFirstName("John");
        homePage.fillInputLastName("Smith");
        DemoHelper.pause();

        homePage.clickClearButton();
        DemoHelper.pause();

        homePage.dismissPopupAlert();

        Assert.assertEquals(homePage.firstName().getAttribute("value"), "John");
        Assert.assertEquals(homePage.lastName().getAttribute("value"), "Smith");

        homePage.refreshPage();

        homePage.clickClearButton();
        DemoHelper.pause();

        homePage.acceptPopupAlert();
    }
}
