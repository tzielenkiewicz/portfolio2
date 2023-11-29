package uitest.m6;

import Foundation.BasicLoansTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class WaitingTest extends BasicLoansTestClass {
    @Test
    public void implicitWaitTest() {
        chDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        loansPage.borrowField().sendKeys("500");


        Assert.assertFalse(loansPage.resultInfo().isDisplayed()); //element istnieje w HTML, ale jeszcze nie jest wyświetlony, na takie elementy metoda timeouts nie działa
        loansPage.resultInfo().click(); //jeśli nie ma w co klikać, to program "przypomina sobie", że ma ustawiony timeouts 6s, jeśli element się pojawi przez ten czas, test przejdzie
    }

    @Test
    public void explicitWaitTest() {
        //explicit wait to metoda raczej stosowana do konkretnych, wyselekcjonowanych czynności podczas testu
        loansPage.borrowField().sendKeys("500");

        WebDriverWait waitingForResult = new WebDriverWait(chDriver, Duration.ofSeconds(6));
        WebElement result = waitingForResult.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        Assert.assertTrue(result.isDisplayed());

        result.click(); //interactable?
    }

    @Test
    public void explicitWaitTestRefactored() {
        loansPage.borrowField().sendKeys("500");

        WebElement result = waitUntilClickable(chDriver, By.id("result"));
        Assert.assertTrue(result.isDisplayed());
    }

    @Test
    public void fluentWaitTest() {
        Wait<WebDriver> wait = new FluentWait<>(chDriver)
                .withTimeout(Duration.ofSeconds(6))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        loansPage.borrowField().sendKeys("500");

        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        result.click();
    }
    public static WebElement waitUntilClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(6)).until(elementToBeClickable(locator));
    }
}
