package uitest.m8;

import Factory.DevToolsFactory;
import Helper.DemoHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v117.emulation.Emulation;
import org.openqa.selenium.devtools.v117.network.Network;
import org.openqa.selenium.devtools.v117.network.model.Request;
import org.openqa.selenium.devtools.v117.network.model.Response;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Optional;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class InterceptRequestTest {

    @Test
    public void captureChromeRequestTrafficTest() {
        ChromeDriver chDriver = new ChromeDriver();
        DevTools chTools = DevToolsFactory.newChromeDevTool(chDriver);
        chTools.addListener(Network.requestWillBeSent(),
                requestEvent -> {
                    Request httpRequest = requestEvent.getRequest();
                    System.out.printf("URL: %s, Method: %s \n", httpRequest.getUrl(), httpRequest.getMethod());
                });
        chDriver.get("http://127.0.0.1:8080/index.html");

        chTools.send(Network.disable());
        chTools.close();
        chDriver.quit();
    }
//test przechodzi, ale niestety wyrzuca dużo błędów i nie wypisuje logów
    @Test
    public void captureFFRequestTrafficTest() {
        FirefoxOptions options = new FirefoxOptions();
        WebDriver ffDriver = new FirefoxDriver(options);

        DevTools ffTools = ((HasDevTools) ffDriver).getDevTools();
        ffTools.createSession();

        ffTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        ffTools.addListener(Network.requestWillBeSent(),
                requestEvent -> {
                    Request httpRequest = requestEvent.getRequest();
                    System.out.printf("URL: %s, Method: %s \n", httpRequest.getUrl(), httpRequest.getMethod());
                });
        ffDriver.get("http://127.0.0.1:8080/index.html");

        ffTools.send(Network.disable());
        ffTools.close();
        ffDriver.quit();
    }

    @Test
    public void captureChromeResponseTrafficTest() {
        ChromeDriver chDriver = new ChromeDriver();
        DevTools chTools = DevToolsFactory.newChromeDevTool(chDriver);

        chTools.addListener(Network.responseReceived(),
                responseReceived -> {
                    Response httpResponse = responseReceived.getResponse();
                    System.out.printf("URL: %s, Status: %s \n", httpResponse.getUrl(), httpResponse.getStatus());
                    Assert.assertTrue(httpResponse.getStatus() <=400);
                });
        chDriver.get("http://127.0.0.1:8080/index.html");

        chTools.send(Network.disable());
        chTools.close();
        chDriver.quit();
    }

    @Test
    public void geolocationTest() {
        ChromeDriver chDriver = new ChromeDriver();
        DevTools chTools = DevToolsFactory.newChromeDevTool(chDriver);
        chTools.send(Emulation.setGeolocationOverride(Optional.of(51.4993), Optional.of(-0.0995), Optional.of(100)));
        chDriver.get("http://127.0.0.1:8080/index.html");
        WebElement location = new WebDriverWait(chDriver, Duration.ofSeconds(5))
                .until(visibilityOfElementLocated(By.id("location")));
        Assert.assertTrue(location.getText().contains("You are visiting us from"));
        DemoHelper.pause();

        chDriver.quit();
    }
    @Test
    public void manipulateChromeTrafficTest() {
        ChromeDriver chDriver = new ChromeDriver();
        DevTools chTools = DevToolsFactory.newChromeDevTool(chDriver);

        //chTools.send(Network.setBlockedURLs(List.of("*/footer.js")));

        chDriver.get("http://127.0.0.1:8080/index.html");
        WebElement location = new WebDriverWait(chDriver, Duration.ofSeconds(5))
                .until(visibilityOfElementLocated(By.id("location")));
        Assert.assertTrue(location.getText().contains("You are visiting us from"));
        DemoHelper.pause();

        chDriver.quit();
    }
}
