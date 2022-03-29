package mentoring._02_enterprise.com;

import org.testng.annotations.Test;

public class testEnterPrice extends enterpriceHome {

    @Test
    public void testEnterPrice() {
        goToUrl();
        sendKeysPickUpLocation("Miami International Airport");
        choosePickUpDate(56,65);
        chooseVehicleClass();
        justifyNumberOfPassenger();
    }
}
