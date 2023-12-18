package uitest.m4;

import Foundation.BasicSavingsTestClass;
import Helper.DemoHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.Savings.Period.ONE_YEAR;
import static pages.Savings.Period.TWO_YEARS;

public class SelectingTest extends BasicSavingsTestClass {
    @Test
    public void selectingTest() {
        savingsPage.inputDepositValue("100");

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

    @Test
    public void selectingTestWithAbstraction() {
        savingsPage.inputDepositValue("500");
        savingsPage.selectTimePeriod(ONE_YEAR);

        Assert.assertTrue(savingsPage.resultInfo().isDisplayed());
        Assert.assertEquals(savingsPage.resultInfo().getText(), "After 1 Year you will earn $25.00 on your deposit");

        savingsPage.clearInputDepositValue();
        savingsPage.inputDepositValue("1000");
        savingsPage.selectTimePeriod(TWO_YEARS);

        Assert.assertEquals(savingsPage.resultInfo().getText(), "After 2 Years you will earn $120.00 on your deposit");
    }
}
