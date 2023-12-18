package uitest.m4;

import Factory.CommonFunctions;
import Foundation.BasicHomeTestClass;
import Helper.DemoHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ClickingTest extends BasicHomeTestClass {
    @Test
    public void clickingTest(){
        CommonFunctions.clickSpecifiedElement(homePage.checkboxHeardAbout());
        CommonFunctions.clickSpecifiedElement(homePage.registerButton());

        DemoHelper.pause();
    }
    @Test
    public void moreClicking() {
        WebElement checkBoxHowHeardAbout = chDriver.findElement(By.id("heard-about"));
        Actions actions = new Actions(chDriver);

        actions.doubleClick(checkBoxHowHeardAbout).perform();
        actions.contextClick(checkBoxHowHeardAbout).perform();

        DemoHelper.pause();
    }
}
