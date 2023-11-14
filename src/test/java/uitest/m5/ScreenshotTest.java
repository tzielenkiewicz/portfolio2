package uitest.m5;

import Helper.DriverFactory;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static Helper.Pages.HOME;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class ScreenshotTest {
    @Test
    public void screenshotTest() throws IOException {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        TakesScreenshot takingScreenshot = (TakesScreenshot) driver;
        File takenScreenshot = takingScreenshot.getScreenshotAs(OutputType.FILE);
        Path destinationPath = Paths.get("failure-screenshot.png");

        Files.move(takenScreenshot.toPath(), destinationPath, REPLACE_EXISTING);

        driver.quit();
    }

    @Test
    public void elementScreenshot() throws IOException {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);
        WebElement foundForm = driver.findElement(By.tagName("form"));

        File takenScreenshot = foundForm.getScreenshotAs(OutputType.FILE);
        Path destinationPath = Paths.get("failure-element-screenshot.png");

        Files.move(takenScreenshot.toPath(), destinationPath, REPLACE_EXISTING);

        driver.quit();
    }
}
