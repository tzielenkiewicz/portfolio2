package uitest.m5;

import Foundation.BasicHomeTestClass;
import Helper.DemoHelper;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ByCssSelectorTest extends BasicHomeTestClass {
    @Test
    public void byCSSTest() {
        WebElement birthDatePicker = homePage.dateOfBirthByCSS();
        birthDatePicker.sendKeys("05012001");
        DemoHelper.chosenTimePause(2500);
        chDriver.navigate().refresh();
        birthDatePicker = homePage.dateOfBirth();
        birthDatePicker.sendKeys("04022001");
        DemoHelper.chosenTimePause(3000);
    }

    @Test
    public void byCSSTest_2() {
        WebElement checkBoxHeardAbout = homePage.checkboxHeardAboutByCSS();
        checkBoxHeardAbout.click();
        System.out.println(checkBoxHeardAbout.isSelected());
        DemoHelper.pause();
    }
}
