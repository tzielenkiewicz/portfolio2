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
import pages.Loans;

import java.time.Duration;

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
        WebDriver chDriver = DriverFactory.createNewChromeDriver();

        WebDriver edDriver = DriverFactory.createNewEdgeDriver();

        WebDriver nexusDriver = DriverFactory.createNewDeviceDriver("Nexus 5");

        DevTools chTools = DevToolsFactory.newChromeDevTool(chDriver);
    }

    @Test
    public void refactoredTestDemo() {
        WebDriver chDriver = DriverFactory.createNewChromeDriver();
        Loans loansPage = Loans.createLoansPage(chDriver);
        loansPage.navigateTo();
        loansPage.borrowField().sendKeys("500");

        WebElement messageReturned = WaitingUtils.waitUntilVisible(chDriver, By.id("result"), 6);
        Assert.assertEquals(messageReturned.getText(), "You will pays us back 1000");
        chDriver.quit();
    }
}
