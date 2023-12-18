package uitest.m5;

import Factory.CommonFunctions;
import Foundation.BasicHomeTestClass;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class ScreenshotTest extends BasicHomeTestClass {
    @Test
    public void screenshotTest() {
        CommonFunctions.takeFullScreenshotAndSaveToFile(chDriver);
    }

    @Test
    public void elementScreenshot() throws IOException {
        WebElement foundForm = homePage.formByTagName();
        CommonFunctions.takeChosenElementScreenshotAndSaveToFile(foundForm);
    }
}
