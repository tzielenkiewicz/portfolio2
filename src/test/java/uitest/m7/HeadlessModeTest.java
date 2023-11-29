package uitest.m7;

import Factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.Home;

public class HeadlessModeTest {
    @Test
    public void headlessTest() {
        WebDriver driver = DriverFactory.createNewHeadlessChromeDriver();
        Home homePage = Home.createHomePage(driver);
        homePage.navigateTo();

        WebElement registerButton = homePage.registerButton();
        System.out.println(registerButton.getText());

        driver.quit();
    }
}
