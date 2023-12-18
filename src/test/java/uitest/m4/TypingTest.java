package uitest.m4;

import Foundation.BasicHomeTestClass;
import Helper.DemoHelper;
import org.testng.annotations.Test;

public class TypingTest extends BasicHomeTestClass {
    @Test
    public void typingTest(){
        homePage.fillInputFirstName("Sofia");
        homePage.fillInputLastName("Diaz");
        homePage.fillEmail("sofia@email.com");
        DemoHelper.pause();
        homePage.clearChosenField("email");
        homePage.clearChosenField("firstName");
        DemoHelper.pause();

        homePage.fillInputFirstName("Lusinda");
        homePage.fillEmail("lusinda@email.com");
        homePage.fillDateOfBirth("21032022");

        DemoHelper.pause();
    }
}
