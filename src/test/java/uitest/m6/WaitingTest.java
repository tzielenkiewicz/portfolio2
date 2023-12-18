package uitest.m6;

import Foundation.BasicLoansTestClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitingTest extends BasicLoansTestClass {
    @Test
    public void implicitWaitTest() {
        loansPage.setImplicitlyWaitTimeout(6);
        WebElement result = loansPage.resultInfo();

        loansPage.fillBorrowField("500");
        Assert.assertFalse(result.isDisplayed()); //element istnieje w HTML, ale jeszcze nie jest wyświetlony, na takie elementy metoda timeouts nie działa

        loansPage.clickSpecifiedElement(result); //jeśli nie ma w co klikać, to program "przypomina sobie", że ma ustawiony timeouts 6s, jeśli element się pojawi przez ten czas, test przejdzie
    }

    @Test
    public void explicitWaitTest() {
        //explicit wait to metoda raczej stosowana do konkretnych, wyselekcjonowanych czynności podczas testu
        loansPage.fillBorrowField("500");

        WebElement result = loansPage.waitForResultForSpecifiedTime(6);
        Assert.assertTrue(result.isDisplayed());

        loansPage.clickSpecifiedElement(result); //interactable?
    }

    @Test
    public void explicitWaitTestRefactored() {
        loansPage.fillBorrowField("500");

        WebElement result = loansPage.waitForResultUntilClickable("result");
        Assert.assertTrue(result.isDisplayed());
    }

    @Test
    public void fluentWaitTest() {
        loansPage.fillBorrowField("500");

        Wait<WebDriver> wait = loansPage.createNewFluentWait(6, 200);

        loansPage.clickResultWithFluentWait(wait);
    }

}
