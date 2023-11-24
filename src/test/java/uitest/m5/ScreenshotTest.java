package uitest.m5;

import Foundation.BasicHomeTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class ScreenshotTest extends BasicHomeTestClass {
    @Test
    public void screenshotTest() throws IOException {
        TakesScreenshot takingScreenshot = (TakesScreenshot) chDriver;
        File takenScreenshot = takingScreenshot.getScreenshotAs(OutputType.FILE);
        Path destinationPath = Paths.get("failure-screenshot.png");

        Files.move(takenScreenshot.toPath(), destinationPath, REPLACE_EXISTING);
    }

    @Test
    public void elementScreenshot() throws IOException {
        WebElement foundForm = chDriver.findElement(By.tagName("form"));

        File takenScreenshot = foundForm.getScreenshotAs(OutputType.FILE);
        Path destinationPath = Paths.get("failure-element-screenshot.png");

        Files.move(takenScreenshot.toPath(), destinationPath, REPLACE_EXISTING);
    }
}
