package uitest.m4;

import Factory.DriverFactory;
import Helper.DemoHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TypingTest {
    @Test
    public void typingTest(){
        WebDriver driver = DriverFactory.initDriver();

        WebElement inputName = driver.findElement(By.id("firstName"));
        WebElement inputLastName = driver.findElement(By.id("lastName"));
        WebElement inputEmail = driver.findElement(By.id("email"));
        WebElement inputDateOfBirth = driver.findElement(By.id("dob"));

        inputName.sendKeys("Sofia");
        inputLastName.sendKeys("Diaz");
        inputEmail.sendKeys("sofia@email.com");
        DemoHelper.pause();
        inputEmail.clear();
        inputEmail.sendKeys("sofia@email.com");

        inputDateOfBirth.sendKeys("21032022");
        DemoHelper.pause();
        driver.quit();
    }
}
