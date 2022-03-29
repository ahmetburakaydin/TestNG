package gun07;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest {


    @Test
    @Parameters({"username", "password"})
    public void loginTest(String username, String password) {
        driver.get(url);
        clickTo(myAccountMainMenu);
        clickTo(myAccounLoginButton);
        sendKeysTo(emailLoginArea, username);
        sendKeysTo(passwordLoginArea, password);
        clickTo(loginSubmitButton);

        clickTo(myAccountMainMenu);
        Assert.assertTrue(driver.findElement(myAccountMainMenu).findElements(myAccountMainMenu).size() > 2);
    }
    @Test
    @Parameters({"text"})
    public void contactTest(String text) {

        clickTo(contactUsMainMenu);
        sendKeysTo(enquiryTextArea, text);
        clickTo(contactUsSubmitButton);

        Assert.assertTrue(driver.findElement(contactUsContinueButton).isDisplayed());

    }
}
