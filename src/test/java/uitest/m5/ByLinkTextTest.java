package uitest.m5;

import Factory.DriverFactory;
import Helper.DemoHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ByLinkTextTest {
    @Test
    public void byLinkText() {
        WebDriver driver = DriverFactory.initDriver();

        DemoHelper.pause();
        driver.findElement(By.linkText("Savings")).click();
        DemoHelper.pause();
        driver.findElement(By.partialLinkText("Reg")).click();
        DemoHelper.pause();

        driver.quit();
    }
}
