package uitest.m7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static Helper.Pages.HOME;

public class HeadlessModeTest {
    @Test
    public void headlessTest() {
        ChromeOptions options = new ChromeOptions();
        //depreciated
        //options.setHeadless(true);
        options.addArguments("headless=true");

        WebDriver driver = new ChromeDriver(options);
        driver.get(HOME);

        WebElement registerButton = driver.findElement(By.id("register"));
        System.out.println(registerButton.getText());

        driver.quit();
    }
}
