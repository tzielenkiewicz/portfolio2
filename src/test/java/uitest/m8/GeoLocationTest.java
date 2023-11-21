package uitest.m8;

import Factory.DevToolsFactory;
import Helper.DemoHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v117.emulation.Emulation;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Optional;

import static Helper.Pages.HOME;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class GeoLocationTest {
    @Test
    public void geoLocationTest() {
        ChromeDriver driver = new ChromeDriver();
        DevTools chTools = DevToolsFactory.newChromeDevTool(driver);

        chTools.send(Emulation.setGeolocationOverride(Optional.of(51.4993), Optional.of(-0.0995), Optional.of(100)));
        driver.get(HOME);
        WebElement userLocation = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(visibilityOfElementLocated(By.id("location")));
        DemoHelper.pause();

        Assert.assertEquals(userLocation.getText(), "You are visiting us from London");

        chTools.close();
        driver.quit();
    }
}
