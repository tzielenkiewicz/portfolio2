package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Home {
    private static final String URL = "file:///" + System.getProperty("user.dir") + "\\src\\web\\index.html";
    private final WebDriver driver;

    private Home(WebDriver driver) {
        this.driver = driver;
    }
    public static Home homePage(WebDriver driver) {
        return new Home(driver);
    }

    public void navigateTo() {
        driver.get(URL);
    }

    public WebElement firstName() {
        return driver.findElement(By.id("firstName"));
    }

    public WebElement lastName() {
        return driver.findElement(By.id("lastName"));
    }

    public WebElement email() {
        return driver.findElement(By.id("email"));
    }

    public WebElement dateOfBirth() {
        return driver.findElement(By.id("dob"));
    }

    public WebElement checkboxHeardAbout() {
        return driver.findElement(By.id("heard-about"));
    }

    public WebElement textArea() {
        return driver.findElement(By.id("textarea"));
    }

    public WebElement clearButton() {
        return driver.findElement(By.id("clear"));
    }

    public WebElement saveButton() {
        return driver.findElement(By.id("save"));
    }

    public WebElement registerButton() {
        return driver.findElement(By.id("register"));
    }

    public List<WebElement> invalidFeedback() {
        return driver.findElements(By.className("invalid-feedback"));
    }

}
