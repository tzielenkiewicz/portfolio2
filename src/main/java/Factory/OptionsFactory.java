package Factory;

import org.openqa.selenium.chrome.ChromeOptions;

public class OptionsFactory {
    public static ChromeOptions headlessOption() {
        ChromeOptions chOptions = new ChromeOptions();
        chOptions.addArguments("headless=true");
        return chOptions;
    }
}
