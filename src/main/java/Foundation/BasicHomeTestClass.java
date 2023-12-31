package Foundation;

import Factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.Home;

public class BasicHomeTestClass {
    protected WebDriver chDriver;
    protected Home homePage;
    @BeforeMethod
    public void driverAndHomePageInitiation(){
        chDriver = DriverFactory.createNewChromeDriver();
        homePage = Home.createHomePage(chDriver);
        homePage.navigateTo();
    }
    @AfterMethod(alwaysRun = true)
    public void cleanup() {
        chDriver.quit();
    }
}
