package uitest.m4;

import Helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static Helper.Pages.HOME;

public class FindMultipleElementsTest {
    @Test
    public void multipleElementsTest() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        List<WebElement> feedbackCompleteView = driver.findElements(By.className("invalid-feedback"));
        printInfo(feedbackCompleteView.get(0).getText());
        printInfo(feedbackCompleteView.get(1).getText());
        printInfo(feedbackCompleteView.get(2).getText());
        driver.findElement(By.id("register")).click();
        printInfo(feedbackCompleteView.get(0).getText());
        printInfo(feedbackCompleteView.get(1).getText());
        printInfo(feedbackCompleteView.get(2).getText());

        driver.quit();
    }

    private void printInfo(String info) {
        System.out.println("Feedback: " + info);
    }
}
