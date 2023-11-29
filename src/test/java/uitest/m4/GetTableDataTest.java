package uitest.m4;

import Factory.CommonFunctions;
import Foundation.BasicSavingsTestClass;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class GetTableDataTest extends BasicSavingsTestClass {
    @Test
    public void getTableData() {
        WebElement table = savingsPage.ratesTable();
        System.out.println("Table data:");
        System.out.println(table.getText());

        System.out.println("Single row data:");
        List<WebElement> tableRows = savingsPage.getTableRows(table);
        System.out.println(tableRows.get(0).getText());

        List<WebElement> rowCells = savingsPage.getRowCells(tableRows.get(1));
        System.out.println("Particular cells data: ");
        CommonFunctions.printEachElementOf(rowCells);
    }
}
