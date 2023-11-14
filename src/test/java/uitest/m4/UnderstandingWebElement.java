package uitest.m4;

import Helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static Helper.Pages.HOME;

public class UnderstandingWebElement {

    @Test
    public void webElementTest() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        WebElement inputName = driver.findElement(By.id("firstName"));
        System.out.println(inputName.isDisplayed());

        WebElement registerButton = driver.findElement(By.id("register"));
        System.out.println(registerButton.getText());

        driver.quit();
    }
}
