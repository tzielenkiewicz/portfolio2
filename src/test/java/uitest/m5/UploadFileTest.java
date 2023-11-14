package uitest.m5;

import Helper.DemoHelper;
import Helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static Helper.Pages.LOANS;

public class UploadFileTest {
    @Test
    public void uploadFileTest() throws IOException {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(LOANS);

        WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
        Path filePath = Files.createTempFile("file", ".txt");
        String fileName = filePath.toAbsolutePath().toString();
        System.out.println(fileName);

        fileInput.sendKeys(fileName);
        DemoHelper.pause();

        driver.quit();
        filePath.toFile().deleteOnExit();
    }
}
