package Foundation;

import Factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.Loans;

public class BasicLoansTestClass {
    protected WebDriver chDriver;
    protected Loans loansPage;
    @BeforeMethod
    public void driverAndLoansPageInitiation(){
        chDriver = DriverFactory.createNewChromeDriver();
        loansPage = Loans.createLoansPage(chDriver);
        loansPage.navigateTo();
    }
    @AfterMethod(alwaysRun = true)
    public void cleanup() {
        chDriver.quit();
    }
}
