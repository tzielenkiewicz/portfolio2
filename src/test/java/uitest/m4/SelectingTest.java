package uitest.m4;

import Foundation.BasicSavingsTestClass;
import Helper.DemoHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectingTest extends BasicSavingsTestClass {
    @Test
    public void selectingTest() {
        WebElement inputDeposit = savingsPage.depositInput();
        inputDeposit.sendKeys("100");

        WebElement dropDownPeriod = savingsPage.periodDropDownChoice();
        Select dropDown = new Select(dropDownPeriod);
        dropDown.selectByValue("6 months");
        DemoHelper.chosenTimePause(1000);
        dropDown.selectByVisibleText("1 Year");
        DemoHelper.chosenTimePause(1000);
        dropDown.selectByIndex(2);

        WebElement resultResponse = savingsPage.resultInfo();
        System.out.println(resultResponse.getText());
        Assert.assertEquals(resultResponse.getText(), "After 2 Years you will earn $12.00 on your deposit");
    }
}
