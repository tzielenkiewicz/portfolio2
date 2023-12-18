package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Loans {
    private static final String URL = "file:///" + System.getProperty("user.dir") + "\\src\\web\\loans.html";
    private final WebDriver driver;

    private Loans(WebDriver driver) {
        this.driver = driver;
    }
    public static Loans createLoansPage(WebDriver driver) {
        return new Loans(driver);
    }
    public void navigateTo() {driver.get(URL);}

    public WebElement fileInputFieldByCSS() { return driver.findElement(By.cssSelector("input[type=file]")); }

    public WebElement borrowField() { return driver.findElement(By.id("borrow")); }

    public WebElement resultInfo() { return driver.findElement(By.id("result")); }

    public void uploadFileProcedure() {
        Path filePath = createFilePath();
        String fileName = filePath.toAbsolutePath().toString();
        fillFileInput(fileName);
        filePath.toFile().deleteOnExit();
    }

    private Path createFilePath() {
        Path filePath;
        try {
            filePath= Files.createTempFile("file", ".txt");
            return filePath;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void fillFileInput(String fileName) { fileInputFieldByCSS().sendKeys(fileName); }

    public void fillBorrowField(String number) {
        borrowField().sendKeys(number);
    }

    public Wait<WebDriver> createNewFluentWait(int secondsOfTimeout, int millisecondsOfPolling) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(secondsOfTimeout))
                .pollingEvery(Duration.ofMillis(millisecondsOfPolling));
    }

    public void clickResultWithFluentWait(Wait<WebDriver> wait) {
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        result.click();
    }

    public WebElement waitForResultUntilClickable(String elementId) {
        return waitUntilClickable(driver, By.id(elementId));
    }

    public static WebElement waitUntilClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(6)).until(elementToBeClickable(locator));
    }

    public WebElement waitForResultForSpecifiedTime(int seconds) {
        WebDriverWait waitingForResult = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return waitingForResult.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
    }

    public void setImplicitlyWaitTimeout(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
}
