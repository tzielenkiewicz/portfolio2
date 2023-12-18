package uitest.m4;

import Foundation.BasicHomeTestClass;
import org.testng.annotations.Test;

public class FindMultipleElementsTest extends BasicHomeTestClass {
    @Test
    public void multipleElementsTest() {
        homePage.printEachElementOfFeedback();

        homePage.clickRegisterButton();

        homePage.printEachElementOfFeedback();
    }
}
