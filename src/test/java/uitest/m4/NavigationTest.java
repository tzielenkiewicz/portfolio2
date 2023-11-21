package uitest.m4;

import Factory.DriverFactory;
import Helper.DemoHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static Helper.Pages.SAVINGS;

public class NavigationTest {
    private static final String PREFIX = "file:///" + System.getProperty("user.dir") + "\\src\\web\\";
    WebDriver driver;
    @Test
    public void basicNavigationTest() {
        driver = Factory.DriverFactory.createdNewChromeDriver();

        driver.get(PREFIX + "index.html");
        DemoHelper.chosenTimePause(5000);

        driver.get(PREFIX + "savings.html");
        DemoHelper.pause();

        driver.navigate().back();
        DemoHelper.pause();
        driver.navigate().forward();
        DemoHelper.pause();
        driver.navigate().refresh();
        DemoHelper.pause();
;
    }
    @Test
    public void basicNavigationTestRefactored(){
        driver = DriverFactory.initDriver();
        driver.get(SAVINGS);

    }

    @AfterMethod
    public void cleanup() {driver.quit();}
}
