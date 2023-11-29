package uitest.m5;

import Foundation.BasicHomeTestClass;
import Helper.DemoHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

public class RelativeLocatorTest extends BasicHomeTestClass {
    @Test
    public void relativeLocatorTest () {
        WebElement email = homePage.email();
        RelativeLocator.RelativeBy input = RelativeLocator.with(By.tagName("input"));
        WebElement birthDatePicker = chDriver.findElement(input.toRightOf(email));
        System.out.println(birthDatePicker.getAttribute("type"));
        DemoHelper.pause();
        WebElement firstName = chDriver.findElement(input.above(email));
        System.out.println(firstName.getAttribute("id"));
        DemoHelper.pause();
    }
}
