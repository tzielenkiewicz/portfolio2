package uitest.m5;

import Helper.DemoHelper;
import Helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ByXpathTest {
    @Test
    public void byXpathTest() {

        WebDriver driver = DriverFactory.newDriver();
        driver.get("https://tzielenkiewicz.github.io/contact.html");
        WebElement githubContactLink = driver.findElement(By.xpath("//*[@id=\"nav2\"]/div[1]/a/i"));
        githubContactLink.click();
        DemoHelper.pause();
        driver.quit();

    }

}
