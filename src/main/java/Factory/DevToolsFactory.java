package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v117.network.Network;

import java.util.Optional;

public class DevToolsFactory {
    public static DevTools newChromeDevTool(WebDriver driver) {
        DevTools chDevTools = ((ChromeDriver) driver).getDevTools();
        chDevTools.createSession();
        chDevTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        return chDevTools;
    }
}
