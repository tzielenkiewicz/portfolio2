package uitest.m5;

import Factory.CommonFunctions;
import Foundation.BasicHomeTestClass;
import Helper.DemoHelper;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.SessionStorage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

import static Helper.Pages.SAVINGS;

public class StorageAndCookiesTest extends BasicHomeTestClass {
    @Test
    public void storageTest() {
        homePage.fillInputFirstName("Maria");
        homePage.fillInputLastName("Diaz");
        homePage.fillDateOfBirth("11/12/1999");
        homePage.fillEmail("maria_diaz@email.com");
        homePage.clickSaveButton();

        SessionStorage savedStorage = CommonFunctions.getSessionStorage(chDriver);
        CommonFunctions.printElementsOfSessionStorage(savedStorage);

        DemoHelper.pause();

        chDriver.get(SAVINGS);
        CommonFunctions.navigateBack(chDriver);

        DemoHelper.pause();

        String currentFirstNameAttributeValue = homePage.firstName().getAttribute("value");
        String currentLastNameAttributeValue = homePage.lastName().getAttribute("value");
        Assert.assertEquals(currentFirstNameAttributeValue, "Maria");
        Assert.assertEquals(currentLastNameAttributeValue, "Diaz");

        CommonFunctions.clearStorage(chDriver);
        homePage.refreshPage();

        DemoHelper.pause();

        String firstNameAfterRefreshAttributeValue = homePage.firstName().getAttribute("value");
        String lastNameAfterRefreshAttributeValue = homePage.lastName().getAttribute("value");

        Assert.assertEquals(firstNameAfterRefreshAttributeValue, "");
        Assert.assertEquals(lastNameAfterRefreshAttributeValue, "");
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
