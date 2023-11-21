package uitest.m5;

import Factory.DriverFactory;
import Helper.DemoHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

public class RelativeLocatorTest {
    @Test
    public void relativeLocatorTest () {
        WebDriver driver = DriverFactory.initDriver();

        WebElement email = driver.findElement(By.id("email"));
        RelativeLocator.RelativeBy input = RelativeLocator.with(By.tagName("input"));
        WebElement birthDatePicker = driver.findElement(input.toRightOf(email));
        System.out.println(birthDatePicker.getAttribute("type"));
        DemoHelper.pause();
        WebElement firstName = driver.findElement(input.above(email));
        System.out.println(firstName.getAttribute("id"));
        DemoHelper.pause();

        driver.quit();
    }
}
