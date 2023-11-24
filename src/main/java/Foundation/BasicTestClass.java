package Foundation;

import Factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasicTestClass {
    protected WebDriver chDriver;

    @BeforeMethod
    public void initDriver() {chDriver = DriverFactory.createdNewChromeDriver();}

    @AfterMethod
    public void cleanup() {chDriver.quit();}
}
