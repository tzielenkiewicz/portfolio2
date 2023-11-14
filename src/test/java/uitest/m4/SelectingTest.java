package uitest.m4;

import Helper.DemoHelper;
import Helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Helper.Pages.SAVINGS;

public class SelectingTest {
    @Test
    public void selectingTest() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(SAVINGS);

        WebElement inputDeposit = driver.findElement(By.id("deposit"));
        inputDeposit.sendKeys("100");

        WebElement dropDownPeriod = driver.findElement(By.id("period"));
        Select dropDown = new Select(dropDownPeriod);
        dropDown.selectByValue("6 months");
        DemoHelper.pause();
        dropDown.selectByVisibleText("1 Year");
        DemoHelper.pause();
        dropDown.selectByIndex(2);

        WebElement resultInfo = driver.findElement(By.id("result"));
        System.out.println(resultInfo.getText());
        Assert.assertEquals(resultInfo.getText(), "After 2 Years you will earn $12.00 on your deposit");

        driver.quit();
    }
}
