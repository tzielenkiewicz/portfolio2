package uitest.m5;

import Factory.CommonFunctions;
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

        CommonFunctions.clickSpecifiedElement(homePage.clearButton());
        DemoHelper.pause();

        homePage.dismissPopupAlert();

        Assert.assertEquals(homePage.firstName().getAttribute("value"), "John");
        Assert.assertEquals(homePage.lastName().getAttribute("value"), "Smith");

        homePage.refreshPage();

        CommonFunctions.clickSpecifiedElement(homePage.clearButton());
        DemoHelper.pause();

        homePage.acceptPopupAlert();
    }
}
