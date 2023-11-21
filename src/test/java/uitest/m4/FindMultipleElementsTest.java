package uitest.m4;

import Factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class FindMultipleElementsTest {
    @Test
    public void multipleElementsTest() {
        WebDriver driver = DriverFactory.initDriver();

        List<WebElement> feedbackCompleteView = driver.findElements(By.className("invalid-feedback"));
        for (WebElement feedback : feedbackCompleteView) {
            printInfo(feedback.getText());
        }

        driver.findElement(By.id("register")).click();

        for (WebElement feedback : feedbackCompleteView) {
            printInfo(feedback.getText());
        }

        driver.quit();
    }

    private void printInfo(String info) {
        System.out.println("Feedback: " + info);
    }
}
