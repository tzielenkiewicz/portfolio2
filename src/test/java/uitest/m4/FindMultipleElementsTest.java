package uitest.m4;

import Factory.CommonFunctions;
import Foundation.BasicHomeTestClass;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class FindMultipleElementsTest extends BasicHomeTestClass {
    @Test
    public void multipleElementsTest() {
        List<WebElement> feedbackCompleteView = homePage.invalidFeedback();

        CommonFunctions.printEachElementOf(feedbackCompleteView);
        homePage.registerButton().click();
        CommonFunctions.printEachElementOf(feedbackCompleteView);
    }
}
