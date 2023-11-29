package uitest.m4;

import Foundation.BasicHomeTestClass;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UnderstandingWebElementTest extends BasicHomeTestClass {

    @Test
    public void webElementTest() {
        WebElement inputName = homePage.firstName();
        System.out.println(inputName.isDisplayed());

        WebElement registerButton = homePage.registerButton();
        System.out.println(registerButton.getText());
    }
}
