package uitest.m5;

import Foundation.BasicHomeTestClass;
import Helper.DemoHelper;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

import static Helper.Pages.SAVINGS;

public class StorageAndCookiesTest extends BasicHomeTestClass {
    @Test
    public void storageTest() {
        WebElement firstName = homePage.firstName();
        WebElement lastName = homePage.lastName();
        WebElement birthDatePicker = homePage.dateOfBirth();
        WebElement email = homePage.email();
        WebElement saveButton = homePage.saveButton();

        firstName.sendKeys("Maria");
        lastName.sendKeys("Diaz");
        birthDatePicker.sendKeys("11/12/1999");
        email.sendKeys("maria_diaz@email.com");
        saveButton.click();

        WebStorage myWebStorage = (WebStorage) chDriver;
        SessionStorage savedStorage = myWebStorage.getSessionStorage();
        savedStorage.keySet().forEach(key -> System.out.println(key + "=" + savedStorage.getItem(key)));

        DemoHelper.pause();

        chDriver.get(SAVINGS);
        chDriver.navigate().back();

        DemoHelper.pause();

        WebElement firstNameFromStorage = homePage.firstName();
        WebElement lastNameFromStorage = homePage.lastName();

        Assert.assertEquals(firstNameFromStorage.getAttribute("value"), "Maria");
        Assert.assertEquals(lastNameFromStorage.getAttribute("value"), "Diaz");

        savedStorage.clear();
        homePage.refreshSite();

        DemoHelper.pause();

        WebElement firstNameAfterRefresh = homePage.firstName();
        WebElement lastNameAfterRefresh = homePage.lastName();

        Assert.assertEquals(firstNameAfterRefresh.getAttribute("value"), "");
        Assert.assertEquals(lastNameAfterRefresh.getAttribute("value"), "");
    }
    @Test
    public void cookiesTest() {
        WebDriver.Options options = chDriver.manage();

        Set<Cookie> cookies = options.getCookies();
        System.out.println(cookies.size());
        Cookie namedThing = options.getCookieNamed("thing");
        System.out.println(namedThing);

        options.deleteAllCookies();
    }
}
