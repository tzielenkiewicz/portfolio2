package uitest.m5;

import Foundation.BasicLoansTestClass;
import org.testng.annotations.Test;

public class UploadFileTest extends BasicLoansTestClass {
    @Test
    public void uploadFileTest() {
        loansPage.uploadFileProcedure();
    }
}
