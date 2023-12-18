package uitest.m5;

import Factory.CommonFunctions;
import Foundation.BasicHomeTestClass;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ScreenshotTest extends BasicHomeTestClass {
    @Test
    public void screenshotTest() {
        CommonFunctions.takeFullScreenshotAndSaveToFile(chDriver);
    }

    @Test
    public void elementScreenshot() {
        WebElement foundForm = homePage.formByTagName();
        CommonFunctions.takeChosenElementScreenshotAndSaveToFile(foundForm);
    }
}
