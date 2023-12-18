package pages;

import Factory.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Savings {
    private static final String URL = "file:///" + System.getProperty("user.dir") + "\\src\\web\\savings.html";
    private final WebDriver driver;

    private Savings(WebDriver driver) {
        this.driver = driver;
    }
    public static Savings createSavingsPage(WebDriver driver) {
        return new Savings(driver);
    }
    public void navigateTo() {driver.get(URL);}

    public WebElement depositInput() {return driver.findElement(By.id("deposit"));}

    public WebElement resultInfo() {return driver.findElement(By.id("result"));}

    public WebElement periodDropDownChoice() {return driver.findElement(By.id("period"));}

    public WebElement ratesTable() {return driver.findElement(By.id("rates"));}
    public WebElement ratesTableByTagName() {return driver.findElement(By.tagName("table"));}

    public WebElement location() {return driver.findElement(By.id("location"));}

    public List<WebElement> getTableRows(WebElement table) {
        return table.findElements(By.tagName("tr"));
    }

    public List<WebElement> getRowCells(WebElement row){
        return row.findElements(By.tagName("td"));
    }

    public void printTableData() {
        System.out.println("Table data:");
        System.out.println(ratesTable().getText());
    }

    public void printTableDataByTagName() {
        System.out.println("Table data:");
        System.out.println(ratesTableByTagName().getText());
    }

    public void printSingleRowTableData(int rowNumber) {
        System.out.println("Single row data (row " + rowNumber + "):");
        System.out.println(getTableRows(ratesTable()).get(rowNumber).getText());
    }

    public void printEachCellOfChosenTableRow(int tableRow) {
        System.out.println("Particular cells data in row "+ tableRow +": ");
        CommonFunctions.printEachElementOf(getRowCells(getTableRows(ratesTable()).get(tableRow)));
    }

    public void inputDepositValue(String depositCount) {
        depositInput().sendKeys(depositCount);
    }

    public void selectTimePeriod(Period chosenPeriod) {
        Select dropdown = new Select(driver.findElement(By.id("period")));
        dropdown.selectByVisibleText(chosenPeriod.toString());
    }

    public void clearInputDepositValue() { depositInput().clear(); }

    public enum Period {
        SIX_MONTHS("6 months"),
        ONE_YEAR("1 Year"),
        TWO_YEARS("2 Years");

        final String chosenPeriod;

        Period(String chosenPeriod) {this.chosenPeriod = chosenPeriod;}
        @Override
        public String toString() {return chosenPeriod;}
    }
}
