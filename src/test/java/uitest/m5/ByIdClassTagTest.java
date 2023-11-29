package uitest.m5;

import Foundation.BasicHomeTestClass;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Savings;

import java.util.List;

public class ByIdClassTagTest extends BasicHomeTestClass {
    @Test
    public void byClassName() {
        homePage.registerButton().click();

        WebElement firstMatchFeedback = homePage.firstMatchInvalidFeedbackInfo();
        System.out.println(firstMatchFeedback.getText());

        List<WebElement> feedbackCompleteView = homePage.invalidFeedback();
        String[] feedbackAnswers ={"Valid first name is required", "Valid last name is required", "Please enter a valid email address"};
        for(int i=0; i<feedbackAnswers.length; i++) {Assert.assertEquals(feedbackCompleteView.get(i).getText(), feedbackAnswers[i]);}

        Savings savingsPage = Savings.createSavingsPage(chDriver);
        savingsPage.navigateTo();
        WebElement table = savingsPage.ratesTableByTagName();
        System.out.println(table.getText());
    }
}
