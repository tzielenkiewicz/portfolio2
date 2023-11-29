package Factory;

import org.openqa.selenium.WebElement;

import java.util.List;

public class CommonFunctions {

    public static void printEachElementOf(List<WebElement> multipleElementsObject) {
        for (WebElement object : multipleElementsObject) {
            System.out.println("Observed text: " + object.getText());
        }
    }
}
