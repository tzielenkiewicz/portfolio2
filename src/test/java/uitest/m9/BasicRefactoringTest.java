package uitest.m9;

import Factory.DevToolsFactory;
import Factory.DriverFactory;
import Wait.WaitingUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static Helper.Pages.LOANS;

public class BasicRefactoringTest {
    @Test
    public void beforeRefactoringTest() {
        ChromeOptions chOptions = new ChromeOptions();
        chOptions.addArguments("headless=true");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
    }

    @Test
    public void newDriverAndToolsTest() {
        WebDriver chDriver = DriverFactory.createdNewChromeDriver();

        WebDriver edDriver = DriverFactory.createdNewEdgeDriver();

        WebDriver nexusDriver = DriverFactory.newDeviceDriver("Nexus 5");

        DevTools chTools = DevToolsFactory.newChromeDevTool(chDriver);
    }

    @Test
    public void refactoredTestDemo() {
        WebDriver chDriver = DriverFactory.createdNewChromeDriver();
        chDriver.get(LOANS);
        chDriver.findElement(By.id("borrow")).sendKeys("500");

        WebElement messageReturned = WaitingUtils.waitUntilVisible(chDriver, By.id("result"), 6);
        Assert.assertEquals(messageReturned.getText(), "You will pays us back 1000");
        chDriver.quit();
    }
}
