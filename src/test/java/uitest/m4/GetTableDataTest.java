package uitest.m4;

import Foundation.BasicSavingsTestClass;
import org.testng.annotations.Test;

public class GetTableDataTest extends BasicSavingsTestClass {
    @Test
    public void getTableData() {
        savingsPage.printTableData();
        savingsPage.printSingleRowTableData(0);
        savingsPage.printEachCellOfChosenTableRow(1);
    }
}
