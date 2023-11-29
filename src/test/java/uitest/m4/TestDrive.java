package uitest.m4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestDrive {
    @Test
    public void test0() {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL("https://tzielenkiewicz.github.io").openConnection();
            System.out.println(connection.getResponseCode());
            System.out.println(connection.getResponseMessage());
            System.out.println(connection.getURL());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void test(){
        WebDriver driver = new ChromeDriver();
        driver.quit();
    }
}
