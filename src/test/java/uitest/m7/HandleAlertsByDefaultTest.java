package uitest.m7;

import Helper.DemoHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static Helper.Pages.HOME;

public class HandleAlertsByDefaultTest {
    @Test
    public void handleAlertsByDefaultTest() {
        ChromeOptions options = new ChromeOptions();
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
        // or options.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);

        WebDriver driver = new ChromeDriver(options);
        driver.get(HOME);

        driver.findElement(By.id("clear")).click();
        driver.findElement(By.id("register")).click();

        DemoHelper.chosenTimePause(5000);
        driver.quit();
    }
}
