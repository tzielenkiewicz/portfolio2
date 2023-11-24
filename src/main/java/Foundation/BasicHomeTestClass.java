package Foundation;

import Factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasicHomeTestClass {
    protected WebDriver chDriver;
    @BeforeMethod
    public void homeInitiation(){
        chDriver = DriverFactory.initDriver();
    }

    @AfterMethod
    public void cleanup() {
        chDriver.quit();
    }
}
