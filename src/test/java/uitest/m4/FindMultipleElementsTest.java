package uitest.m4;

import Factory.CommonFunctions;
import Foundation.BasicHomeTestClass;
import org.testng.annotations.Test;

public class FindMultipleElementsTest extends BasicHomeTestClass {
    @Test
    public void multipleElementsTest() {
        homePage.printEachElementOfFeedback();

        CommonFunctions.clickSpecifiedElement(homePage.registerButton());

        homePage.printEachElementOfFeedback();
    }
}
