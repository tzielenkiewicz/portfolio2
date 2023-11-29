package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Map;

import static Factory.OptionsFactory.headlessOption;
import static Helper.Pages.HOME;

public class DriverFactory {

    public static WebDriver createNewHeadlessChromeDriver() {
        WebDriver driver = new ChromeDriver(headlessOption());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return driver;
    }

    public static WebDriver createNewChromeDriver() {
        return appliedCommonSetupDriver(new ChromeDriver());
    }
    public static WebDriver createNewEdgeDriver() {
        return appliedCommonSetupDriver(new EdgeDriver());
    }

    public static WebDriver createNewFirefoxDriver() {
        return appliedCommonSetupDriver(new FirefoxDriver());
    }

    public static WebDriver createNewDeviceDriver(String deviceName) {
        Map<String, String> mobileEmulation = Map.of("deviceName", deviceName);
        ChromeOptions chOptions = new ChromeOptions();
        chOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        return new ChromeDriver(chOptions);
    }
    private static WebDriver appliedCommonSetupDriver(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return driver;
    }


    public static WebDriver initDriver() {
        WebDriver driver = DriverFactory.createNewChromeDriver();
        driver.get(HOME);
        return driver;
    }
}
