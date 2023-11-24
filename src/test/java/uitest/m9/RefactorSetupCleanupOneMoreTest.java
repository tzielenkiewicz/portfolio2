package uitest.m9;

import Foundation.BasicTestClass;
import Wait.WaitingUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Helper.Pages.LOANS;

public class RefactorSetupCleanupOneMoreTest extends BasicTestClass {
    @Test
    public void refactoredTest() {
        chDriver.get(LOANS);
        chDriver.findElement(By.id("borrow")).sendKeys("500");

        WebElement message = WaitingUtils.waitUntilVisible(chDriver, By.id("result"), 6);
        Assert.assertEquals(message.getText(), "You will pays us back 1000");
    }

    @Test
    public void refactoredTestDuplicate() {
        chDriver.get(LOANS);
        chDriver.findElement(By.id("borrow")).sendKeys("100");

        WebElement message = WaitingUtils.waitUntilVisible(chDriver, By.id("result"), 6);
        Assert.assertEquals(message.getText(), "You will pays us back 200");
    }
}
