package uitest.m7;

import Helper.DemoHelper;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowSizeTest{
    @Test
    public void windowSizeTest() {
        WebDriver driver = new ChromeDriver();
        WebDriver.Window myWindow = driver.manage().window();

        DemoHelper.pause();
        myWindow.maximize();

        DemoHelper.pause();
        myWindow.minimize();

        DemoHelper.pause();
        myWindow.setSize(new Dimension(1200, 800));

        DemoHelper.pause();
        driver.quit();
    }
}
