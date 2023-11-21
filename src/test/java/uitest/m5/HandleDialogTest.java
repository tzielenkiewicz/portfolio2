package uitest.m5;

import Factory.DriverFactory;
import Helper.DemoHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleDialogTest {
    @Test
    public void dismissAlertTest() {
        WebDriver driver = DriverFactory.initDriver();

        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        firstName.sendKeys("John");
        lastName.sendKeys("Smith");
        DemoHelper.pause();

        driver.findElement(By.id("clear")).click();
        DemoHelper.pause();

        Alert alertPopup = driver.switchTo().alert();
        alertPopup.dismiss();

        Assert.assertEquals(firstName.getAttribute("value"), "John");
        Assert.assertEquals(lastName.getAttribute("value"), "Smith");

        driver.navigate().refresh();

        driver.findElement(By.id("clear")).click();
        DemoHelper.pause();

        alertPopup.accept();

        driver.quit();
    }
}
