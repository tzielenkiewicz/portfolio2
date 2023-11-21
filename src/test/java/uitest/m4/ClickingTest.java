package uitest.m4;

import Factory.DriverFactory;
import Helper.DemoHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClickingTest {
    WebDriver driver;
    @BeforeMethod
    public void driverInitiation() {
        driver = DriverFactory.initDriver();
    }
    @Test
    public void clickingTest(){
        WebElement checkBoxHowHeardAbout = driver.findElement(By.id("heard-about"));
        WebElement buttonRegister = driver.findElement(By.id("register"));

        checkBoxHowHeardAbout.click();
        buttonRegister.click();
        DemoHelper.pause();
    }
    @Test
    public void moreClicking() {
        WebElement checkBoxHowHeardAbout = driver.findElement(By.id("heard-about"));
        Actions actions = new Actions(driver);

        actions.doubleClick(checkBoxHowHeardAbout).perform();
        actions.contextClick(checkBoxHowHeardAbout).perform();
        DemoHelper.pause();
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }
}
