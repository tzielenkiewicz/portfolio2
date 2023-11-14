package uitest.m5;

import Helper.DemoHelper;
import Helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static Helper.Pages.HOME;

public class ByLinkTextTest {
    @Test
    public void byLinkText() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        DemoHelper.pause();
        driver.findElement(By.linkText("Savings")).click();
        DemoHelper.pause();
        driver.findElement(By.partialLinkText("Reg")).click();
        DemoHelper.pause();

        driver.quit();
    }
}
