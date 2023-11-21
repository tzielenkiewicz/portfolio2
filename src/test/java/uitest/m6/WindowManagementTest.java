package uitest.m6;

import Factory.DriverFactory;
import Helper.DemoHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Helper.Pages.SAVINGS;

public class WindowManagementTest {
    @Test
    public void tabsAndWindowsTest() {
        WebDriver driver = DriverFactory.initDriver();

        String firstTab = driver.getWindowHandle();

        DemoHelper.pause();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(SAVINGS);
        Assert.assertEquals(driver.getWindowHandles().size(), 2);

        driver.switchTo().window(firstTab);
        DemoHelper.pause();
        driver.close();
        Assert.assertEquals(driver.getWindowHandles().size(), 1);

        driver.quit();
    }
}
