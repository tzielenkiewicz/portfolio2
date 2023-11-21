package uitest.m5;

import Helper.DemoHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ByCssSelectorTest {
    WebDriver driver;
    @BeforeMethod
    public void initiation() {
        driver = Factory.DriverFactory.initDriver();
    }
    @Test
    public void byCSSTest() {
        WebElement birthDatePicker = driver.findElement(By.cssSelector("input[type=date]"));
        birthDatePicker.sendKeys("05012001");
        DemoHelper.chosenTimePause(2500);
        driver.navigate().refresh();
        birthDatePicker = driver.findElement(By.id("dob"));
        birthDatePicker.sendKeys("04022001");
        DemoHelper.chosenTimePause(3000);
    }

    @Test
    public void byCSSTest_2() {
        WebElement checkBox = driver.findElement(By.cssSelector("[type=checkbox]:not(:checked)"));
        checkBox.click();
        System.out.println(checkBox.isSelected());
        DemoHelper.pause();
    }

    @AfterMethod
    public void cleanup() {driver.quit();}
}
