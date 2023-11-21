package uitest.m5;

import Factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static Helper.Pages.SAVINGS;


public class ByIdClassTagTest {
    @Test
    public void byClassName() {
        WebDriver driver = DriverFactory.initDriver();
        driver.findElement(By.id("register")).click();

        WebElement firstMatchFeedback = driver.findElement(By.className("invalid-feedback"));
        System.out.println(firstMatchFeedback.getText());

        List<WebElement> feedbackCompleteView = driver.findElements(By.className("invalid-feedback"));
        String[] feedbackAnswers ={"Valid first name is required", "Valid last name is required", "Please enter a valid email address"};
        for(int i=0; i<feedbackAnswers.length; i++) {Assert.assertEquals(feedbackCompleteView.get(i).getText(), feedbackAnswers[i]);}

        driver.get(SAVINGS);
        WebElement soleTable = driver.findElement(By.tagName("table"));
        System.out.println(soleTable.getText());

        driver.quit();
    }
}
