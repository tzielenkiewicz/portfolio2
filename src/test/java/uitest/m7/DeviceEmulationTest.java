package uitest.m7;

import Factory.DriverFactory;
import Helper.DemoHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static Helper.Pages.HOME;

public class DeviceEmulationTest {
    @Test
    public void deviceEmulationTest() {
        WebDriver driver = DriverFactory.createNewDeviceDriver("Nexus 5");
        driver.get(HOME);

        DemoHelper.pause();
        driver.quit();
    }
}
