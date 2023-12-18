package uitest.m7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Home;

import java.time.Duration;
import java.util.logging.Level;

public class LogCaptureTest {
    @Test
    public void logCaptureTest() {
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.BROWSER, Level.ALL);

        ChromeOptions options = new ChromeOptions();
        options.setCapability(ChromeOptions.LOGGING_PREFS, logs);

        WebDriver chDriver = new ChromeDriver(options);
        chDriver.manage().window().maximize();
        chDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        Home homePage = Home.createHomePage(chDriver);
        homePage.navigateTo();
        homePage.clickRegisterButton();

        LogEntries browserLogs = chDriver.manage().logs().get(LogType.BROWSER);
        Assert.assertFalse(browserLogs.getAll().isEmpty());

        browserLogs.forEach(System.out::println);

        browserLogs.forEach(logEntry -> System.out.println(logEntry.getLevel() + " " + logEntry.getMessage()));

        //browserLogs.forEach(this::checkNoError);
        chDriver.quit();
    }

    private void checkNoError(LogEntry logEntry) {
        Assert.assertNotEquals(logEntry.getLevel().getName(), "SEVERE");
    }

}
