package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loans {
    private static final String URL = "file:///" + System.getProperty("user.dir") + "\\src\\web\\loans.html";
    private final WebDriver driver;

    private Loans(WebDriver driver) {
        this.driver = driver;
    }
    public static Loans createLoansPage(WebDriver driver) {
        return new Loans(driver);
    }
    public void navigateTo() {driver.get(URL);}

    public WebElement fileInputFieldByCSS() { return driver.findElement(By.cssSelector("input[type=file]")); }

    public WebElement borrowField() { return driver.findElement(By.id("borrow")); }

    public WebElement resultInfo() { return driver.findElement(By.id("result")); }
}
