package uitest.m5;

import Foundation.BasicLoansTestClass;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UploadFileTest extends BasicLoansTestClass {
    @Test
    public void uploadFileTest() throws IOException {
        WebElement fileInput = loansPage.fileInputFieldByCSS();
        Path filePath = Files.createTempFile("file", ".txt");
        String fileName = filePath.toAbsolutePath().toString();
        System.out.println(fileName);

        fileInput.sendKeys(fileName);
        filePath.toFile().deleteOnExit();
    }
}
