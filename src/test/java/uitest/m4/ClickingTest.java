package uitest.m4;

import Helper.DemoHelper;
import Helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static Helper.Pages.HOME;

public class ClickingTest {
    @Test
    public void clickingTest(){
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        WebElement inputName = driver.findElement(By.id("firstName"));
        WebElement checkBoxHowHeardAbout = driver.findElement(By.id("heard-about"));
        WebElement buttonRegister = driver.findElement(By.id("register"));

        checkBoxHowHeardAbout.click();
        buttonRegister.click();
        DemoHelper.pause();
        driver.quit();
    }

    @Test
    public void moreClicking() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);
        WebElement checkBoxHowHeardAbout = driver.findElement(By.id("heard-about"));
        Actions actions = new Actions(driver);

        actions.doubleClick(checkBoxHowHeardAbout).perform();
        actions.contextClick(checkBoxHowHeardAbout).perform();
        DemoHelper.pause();

        driver.quit();
    }
}
