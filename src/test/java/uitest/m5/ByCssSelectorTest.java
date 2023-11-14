package uitest.m5;

import Helper.DemoHelper;
import Helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static Helper.Pages.HOME;

public class ByCssSelectorTest {
    @Test
    public void byCSSTest() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        WebElement birthDatePicker = driver.findElement(By.cssSelector("input[type=date]"));
        birthDatePicker.sendKeys("05012001");
        DemoHelper.pause();
        driver.navigate().refresh();
        birthDatePicker = driver.findElement(By.id("dob"));
        birthDatePicker.sendKeys("04022001");
        DemoHelper.pause();

        driver.quit();

    }

    @Test
    public void byCSSTest_2() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        WebElement checkBox = driver.findElement(By.cssSelector("[type=checkbox]:not(:checked)"));
        checkBox.click();
        DemoHelper.pause();

        driver.quit();
    }
}
