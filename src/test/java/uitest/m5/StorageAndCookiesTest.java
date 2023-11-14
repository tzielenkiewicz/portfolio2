package uitest.m5;

import Helper.DemoHelper;
import Helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

import static Helper.Pages.HOME;
import static Helper.Pages.SAVINGS;

public class StorageAndCookiesTest {
    @Test
    public void storageTest() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        WebElement birthDatePicker = driver.findElement(By.id("dob"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement saveButton = driver.findElement(By.id("save"));

        firstName.sendKeys("Maria");
        lastName.sendKeys("Diaz");
        birthDatePicker.sendKeys("11/12/1999");
        email.sendKeys("maria_diaz@email.com");
        saveButton.click();

        WebStorage myWebStorage = (WebStorage) driver;
        SessionStorage savedStorage = myWebStorage.getSessionStorage();
        savedStorage.keySet().forEach(key -> System.out.println(key + "=" + savedStorage.getItem(key)));

        DemoHelper.pause();

        driver.get(SAVINGS);
        driver.navigate().back();

        DemoHelper.pause();

        WebElement firstNameFromStorage = driver.findElement(By.id("firstName"));
        WebElement lastNameFromStorage = driver.findElement(By.id("lastName"));

        Assert.assertEquals(firstNameFromStorage.getAttribute("value"), "Maria");
        Assert.assertEquals(lastNameFromStorage.getAttribute("value"), "Diaz");

        savedStorage.clear();
        driver.navigate().refresh();

        DemoHelper.pause();

        WebElement firstNameAfterRefresh = driver.findElement(By.id("firstName"));
        WebElement lastNameAfterRefresh = driver.findElement(By.id("lastName"));

        Assert.assertEquals(firstNameAfterRefresh.getAttribute("value"), "");
        Assert.assertEquals(lastNameAfterRefresh.getAttribute("value"), "");




        driver.quit();
    }
    @Test
    public void cookiesTest() {
        WebDriver driver = DriverFactory.newDriver();
        WebDriver.Options options = driver.manage();

        Set<Cookie> cookies = options.getCookies();
        Cookie namedThing = options.getCookieNamed("thing");
        options.deleteAllCookies();

        driver.quit();

    }

}
