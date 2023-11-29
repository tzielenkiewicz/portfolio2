package uitest.m9;

import Foundation.BasicLoansTestClass;
import Wait.WaitingUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RefactorSetupCleanupTest extends BasicLoansTestClass {
    @Test
    public void refactoredTest() {
        loansPage.borrowField().sendKeys("500");

        WebElement messageReturned = WaitingUtils.waitUntilVisible(chDriver, By.id("result"), 6);
        Assert.assertEquals(messageReturned.getText(), "You will pays us back 1000");
    }
    @Test
    public void refactoredTestDuplicated() {
        loansPage.borrowField().sendKeys("100");

        WebElement messageReturned = WaitingUtils.waitUntilVisible(chDriver, By.id("result"), 6);
        Assert.assertEquals(messageReturned.getText(), "You will pays us back 200");
    }
}
