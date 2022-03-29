package mentoring._01_hotels.com;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class test01 extends HomeCheck {

    @Test
    void Test_02() throws InterruptedException {
        openSite(url);
        sendKeysTo(searchText,"Manhattan");
        checkInOutTime(35,55);
        clickTo(submitButton);
        clickTo(wait.until(ExpectedConditions.visibilityOfElementLocated(uzaklıkButton)));
        clickTo(wait.until(ExpectedConditions.visibilityOfElementLocated(cadde5Button)));
        verifyLeastFiftyOtels();
        verifyHotelDistance();
    }
    
}
