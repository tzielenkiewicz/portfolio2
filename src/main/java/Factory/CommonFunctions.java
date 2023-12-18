package Factory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class CommonFunctions {

    public static void printEachElementOf(List<WebElement> multipleElementsObject) {
        for (WebElement object : multipleElementsObject) {
            System.out.println("Observed text: " + object.getText());
        }
    }

    public static void printChosenElement(WebElement object) {
        System.out.println(object.getText());
    }

    public static void takeFullScreenshotAndSaveToFile(WebDriver chDriver) {
        TakesScreenshot takingScreenshot = (TakesScreenshot) chDriver;
        File takenScreenshot = takingScreenshot.getScreenshotAs(OutputType.FILE);
        Path destinationPath = Paths.get("fullScreenshot.png");
        try {
            Files.move(takenScreenshot.toPath(), destinationPath, REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void takeChosenElementScreenshotAndSaveToFile(WebElement chosenElement) {
        File takenScreenshot = chosenElement.getScreenshotAs(OutputType.FILE);
        Path destinationPath = Paths.get("chosenElementScreenshot.png");
        try {
            Files.move(takenScreenshot.toPath(), destinationPath, REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printElementsOfSessionStorage(SessionStorage savedStorage) {
        savedStorage.keySet().forEach(key -> System.out.println(key + "=" + savedStorage.getItem(key)));
    }

    public static void navigateBack(WebDriver driver) { driver.navigate().back(); }

    public static void navigateForward(WebDriver driver) { driver.navigate().forward();}

    public static void clearStorage(WebDriver driver) {
        getSessionStorage(driver).clear();
    }

    public static SessionStorage getSessionStorage(WebDriver driver) {
        WebStorage myWebStorage = (WebStorage) driver;
        return myWebStorage.getSessionStorage();
    }
}
