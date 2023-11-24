package uitest.m8;

import Helper.DemoHelper;
import Wait.WaitingUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MorelePriceRangeTest {
    @Test
    public void priceRangeTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.morele.net/kategoria/akcesoria-poleasingowe-1473/");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement priceFrom = WaitingUtils.waitUntilClickable(driver, By.xpath("/html/body/main/div/div[1]/div[2]/div[1]/div[5]/div[1]/div[2]/div[2]/div[2]/div/div[1]/input"));
        WebElement priceTo = WaitingUtils.waitUntilClickable(driver, By.xpath("/html/body/main/div/div[1]/div[2]/div[1]/div[5]/div[1]/div[2]/div[2]/div[2]/div/div[2]/input"));

        Assert.assertNotEquals(priceFrom.getAttribute("value"), "200");

        priceFrom.click();
        priceFrom.sendKeys(Keys.CONTROL +"a");
        priceFrom.sendKeys(Keys.DELETE);
        priceFrom.sendKeys("200");
        Assert.assertEquals(priceFrom.getAttribute("value"), "200");
        DemoHelper.chosenTimePause(3000);

        Assert.assertNotEquals(priceTo.getAttribute("value"), "1000");

        priceTo.sendKeys(Keys.CONTROL +"a");
        priceTo.sendKeys(Keys.DELETE);
        priceTo.sendKeys("1000");
        priceTo.sendKeys(Keys.ENTER);
        Assert.assertEquals(priceTo.getAttribute("value"), "1 000");

        DemoHelper.chosenTimePause(5000);

        driver.quit();
    }
}
