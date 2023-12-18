package pages;

import Factory.CommonFunctions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Home {
    private static final String URL = "file:///" + System.getProperty("user.dir") + "\\src\\web\\index.html";
    private final WebDriver driver;

    private Home(WebDriver driver) {
        this.driver = driver;
    }
    public static Home createHomePage(WebDriver driver) {
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

    public WebElement checkboxHeardAboutByCSS() {return driver.findElement(By.cssSelector("[type=checkbox]:not(:checked)"));}

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

    public WebElement dateOfBirthByCSS() {return driver.findElement(By.cssSelector("input[type=date]"));}

    public Alert switchToAlert() {
        return driver.switchTo().alert();
    }

    public WebElement firstMatchInvalidFeedbackInfo() {return driver.findElement(By.className("invalid-feedback"));}

    public WebElement userLocationDetails(WebDriver chDriver) {
        return new WebDriverWait(chDriver, Duration.ofSeconds(3)).until(visibilityOfElementLocated(By.id("location")));
    }

    public void fillTextArea(String yourKeys) {
        textArea().sendKeys(yourKeys);
    }

    public void printEachElementOfFeedback() {
        CommonFunctions.printEachElementOf(invalidFeedback());
    }

    public void fillInputFirstName(String name) {
        firstName().sendKeys(name);
    }

    public void fillInputLastName(String surname) {
        lastName().sendKeys(surname);
    }

    public void fillEmail(String mail) {
        email().sendKeys(mail);
    }

    public void clearChosenField(String field) {
        switch (field) {
            case "email" -> email().clear();
            case "firstName" -> firstName().clear();
            case "lastName" -> lastName().clear();
            case "dob" -> dateOfBirth().clear();
            default -> System.out.println("Nie ma pola o nazwie " + field + "!");
        }
    }

    public void fillDateOfBirth(String date) {
        dateOfBirth().sendKeys(date);
    }

    public void fillDateOfBirthUsingCSSLocator(String date) { dateOfBirthByCSS().sendKeys(date); }

    public void refreshPage() { driver.navigate().refresh(); }

    public void isCheckBoxHeardAboutSelected() { checkboxHeardAbout().isSelected(); }

    public void printFirstMatchFeedback() { CommonFunctions.printChosenElement(firstMatchInvalidFeedbackInfo()); }

    public void assertFeedbackMultipleInformation(String[] feedbackAnswers) {
        for(int i=0; i<feedbackAnswers.length; i++) {
            Assert.assertEquals(invalidFeedback().get(i).getText(), feedbackAnswers[i]);
        }
    }

    public void dismissPopupAlert() { switchToAlert().dismiss(); }

    public void acceptPopupAlert() { switchToAlert().accept(); }

    public WebElement formByTagName() { return driver.findElement(By.tagName("form")); }

}
