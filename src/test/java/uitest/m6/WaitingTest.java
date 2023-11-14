package uitest.m6;

import Helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static Helper.Pages.LOANS;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class WaitingTest {

    WebDriver driver;
    @Test
    public void implicitWaitTest() {
        driver = new ChromeDriver();
        driver.get(LOANS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        driver.findElement(By.id("borrow")).sendKeys("500");

        Assert.assertFalse(driver.findElement(By.id("result")).isDisplayed()); //element istnieje w HTML, ale jeszcze nie jest wyświetlony, na takie elementy metoda timeouts nie działa
        driver.findElement(By.id("result")).click(); //jeśli nie ma w co klikać, to program "przypomina sobie", że ma ustawiony timeouts 6s, jeśli element się pojawi przez ten czas, test przejdzie

    }

    @Test
    public void explicitWaitTest() {
        //explicit wait to metoda raczej stosowana do konkretnych, wyselekcjonowanych czynności podczas testu
        driver = new ChromeDriver();
        driver.get(LOANS);
        driver.findElement(By.id("borrow")).sendKeys("500");

        WebDriverWait waitingForResult = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement result = waitingForResult.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        Assert.assertTrue(result.isDisplayed());

        result.click(); //interactable?

    }

    public static WebElement waitUntilClicable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(6)).until(elementToBeClickable(locator));
    }

    @Test
    public void explicitWaitTestRefactored() {
        driver = new ChromeDriver();
        driver.get(LOANS);
        driver.findElement(By.id("borrow")).sendKeys("500");

        WebElement result = waitUntilClicable(driver, By.id("result"));
        Assert.assertTrue(result.isDisplayed());

    }

    @Test
    public void fluentWaitTest() {
        driver = DriverFactory.newDriver();
        driver.get(LOANS);
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(6))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        driver.findElement(By.id("borrow")).sendKeys("500");

        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        result.click();

    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }
}
