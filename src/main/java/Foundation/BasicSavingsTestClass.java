package Foundation;

import Factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.Savings;

public class BasicSavingsTestClass {
    protected WebDriver chDriver;
    protected Savings savingsPage;
    @BeforeMethod
    public void driverAndSavingsPageInitiation(){
        chDriver = DriverFactory.createNewChromeDriver();
        savingsPage = Savings.createSavingsPage(chDriver);
        savingsPage.navigateTo();
    }
    @AfterMethod(alwaysRun = true)
    public void cleanup() {
        chDriver.quit();
    }
}
