package uitest.m5;

import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class ScreenshotTest {
    WebDriver driver;
    @BeforeMethod
    public void initiation() {
        driver = Factory.DriverFactory.initDriver();
    }
    @Test
    public void screenshotTest() throws IOException {
        TakesScreenshot takingScreenshot = (TakesScreenshot) driver;
        File takenScreenshot = takingScreenshot.getScreenshotAs(OutputType.FILE);
        Path destinationPath = Paths.get("failure-screenshot.png");

        Files.move(takenScreenshot.toPath(), destinationPath, REPLACE_EXISTING);
    }

    @Test
    public void elementScreenshot() throws IOException {
        WebElement foundForm = driver.findElement(By.tagName("form"));

        File takenScreenshot = foundForm.getScreenshotAs(OutputType.FILE);
        Path destinationPath = Paths.get("failure-element-screenshot.png");

        Files.move(takenScreenshot.toPath(), destinationPath, REPLACE_EXISTING);
    }

    @AfterMethod
    public void cleanup() {driver.quit();}
}
