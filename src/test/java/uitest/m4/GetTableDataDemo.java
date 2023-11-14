package uitest.m4;

import Helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static Helper.Pages.SAVINGS;

public class GetTableDataDemo {

    @Test
    public void getTableData() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(SAVINGS);
        WebElement table = driver.findElement(By.id("rates"));
        System.out.println("Table data:");
        System.out.println(table.getText());

        System.out.println("Single row data:");
        List<WebElement> tableRows = table.findElements(By.tagName("tr"));
        System.out.println(tableRows.get(0).getText());

        List<WebElement> rowCells = tableRows.get(1).findElements(By.tagName("td"));
        System.out.println("Particular cells data: ");
        for (WebElement cell: rowCells) {
            System.out.println(cell.getText());
        }

        driver.quit();
    }

}
