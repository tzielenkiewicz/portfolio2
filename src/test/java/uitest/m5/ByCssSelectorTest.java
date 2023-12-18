package uitest.m5;

import Foundation.BasicHomeTestClass;
import Helper.DemoHelper;
import org.testng.annotations.Test;

public class ByCssSelectorTest extends BasicHomeTestClass {
    @Test
    public void byCSSTest() {
        homePage.fillDateOfBirthUsingCSSLocator("05012001");

        DemoHelper.chosenTimePause(2500);

        homePage.refreshPage();
        homePage.fillDateOfBirthUsingCSSLocator("04022001");

        DemoHelper.chosenTimePause(3000);
    }

    @Test
    public void byCSSTest_2() {
        homePage.clickCheckBoxHowHeardAboutUsingCSSLocator();
        homePage.isCheckBoxHeardAboutSelected();
        DemoHelper.pause();
    }
}
