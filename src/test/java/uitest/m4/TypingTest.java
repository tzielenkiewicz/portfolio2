package uitest.m4;

import Foundation.BasicHomeTestClass;
import Helper.DemoHelper;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TypingTest extends BasicHomeTestClass {
    @Test
    public void typingTest(){
        WebElement inputName = homePage.firstName();
        WebElement inputLastName = homePage.lastName();
        WebElement inputEmail = homePage.email();
        WebElement inputDateOfBirth = homePage.dateOfBirth();

        inputName.sendKeys("Sofia");
        inputLastName.sendKeys("Diaz");
        inputEmail.sendKeys("sofia@email.com");
        DemoHelper.pause();
        inputEmail.clear();
        inputEmail.sendKeys("sofia@email.com");

        inputDateOfBirth.sendKeys("21032022");
        DemoHelper.pause();
    }
}
