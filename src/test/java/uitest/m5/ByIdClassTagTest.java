package uitest.m5;

import Factory.CommonFunctions;
import Foundation.BasicHomeTestClass;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.Savings;

import java.util.List;

public class ByIdClassTagTest extends BasicHomeTestClass {
    @Test
    public void byClassName() {
        CommonFunctions.clickSpecifiedElement(homePage.registerButton());

        homePage.printFirstMatchFeedback();

        List<WebElement> feedbackCompleteView = homePage.invalidFeedback();
        String[] feedbackAnswers ={"Valid first name is required", "Valid last name is required", "Please enter a valid email address"};
        homePage.assertFeedbackMultipleInformation(feedbackAnswers);

        Savings savingsPage = Savings.createSavingsPage(chDriver);
        savingsPage.navigateTo();
        savingsPage.printTableDataByTagName();
    }
}
