package uitest.m5;

import Helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static Helper.Pages.HOME;
import static Helper.Pages.SAVINGS;


public class ByIdClassTagTest {
    @Test
    public void byClassName() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);
        driver.findElement(By.id("register")).click();

        WebElement firstMatchFeedback = driver.findElement(By.className("invalid-feedback"));

        List<WebElement> feedbackCompleteView = driver.findElements(By.className("invalid-feedback"));
        Assert.assertEquals(feedbackCompleteView.get(0).getText(), "Valid first name is required");
        Assert.assertEquals(feedbackCompleteView.get(1).getText(), "Valid last name is required");
        Assert.assertEquals(feedbackCompleteView.get(2).getText(), "Please enter a valid email address");

        driver.get(SAVINGS);
        WebElement soleTable = driver.findElement(By.tagName("table"));
        System.out.println(soleTable.getText());


        driver.quit();



    }
}
