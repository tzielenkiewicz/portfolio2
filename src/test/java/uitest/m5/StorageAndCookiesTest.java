package uitest.m5;

import Factory.DriverFactory;
import Helper.DemoHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static Helper.Pages.SAVINGS;

public class StorageAndCookiesTest {
    WebDriver driver;
    @Test
    public void storageTest() {
        driver = Factory.DriverFactory.initDriver();

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
    }
    @Test
    public void cookiesTest() {
        driver = DriverFactory.initDriver();
        WebDriver.Options options = driver.manage();

        Set<Cookie> cookies = options.getCookies();
        System.out.println(cookies.size());
        Cookie namedThing = options.getCookieNamed("thing");

        options.deleteAllCookies();
    }

    @AfterMethod
    public void cleanup() {driver.quit();}
}
