package uitest.m5;

import Foundation.BasicHomeTestClass;
import Helper.DemoHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ByCssSelectorTest extends BasicHomeTestClass {
    @Test
    public void byCSSTest() {
        WebElement birthDatePicker = chDriver.findElement(By.cssSelector("input[type=date]"));
        birthDatePicker.sendKeys("05012001");
        DemoHelper.chosenTimePause(2500);
        chDriver.navigate().refresh();
        birthDatePicker = chDriver.findElement(By.id("dob"));
        birthDatePicker.sendKeys("04022001");
        DemoHelper.chosenTimePause(3000);
    }

    @Test
    public void byCSSTest_2() {
        WebElement checkBox = chDriver.findElement(By.cssSelector("[type=checkbox]:not(:checked)"));
        checkBox.click();
        System.out.println(checkBox.isSelected());
        DemoHelper.pause();
    }
}
