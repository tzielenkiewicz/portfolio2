package uitest.m7;

import Factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static Helper.Pages.HOME;

public class HeadlessModeTest {
    @Test
    public void headlessTest() {
        WebDriver driver = DriverFactory.createdNewHeadlessChromeDriver();
        driver.get(HOME);

        WebElement registerButton = driver.findElement(By.id("register"));
        System.out.println(registerButton.getText());

        driver.quit();
    }
}
