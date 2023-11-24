package uitest.m9.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PomAbstractionLevelOneTest {
    WebDriver driver;

    @BeforeMethod
    public void initDriver() {
        driver = new ChromeDriver();
    }

    @Test
    public void homePageTest() {

    }

    @AfterMethod
    public void cleanup() {driver.quit();}
}
