package gun02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ParentClass;

import java.util.List;

public class _06_Ornek extends ParentClass {

    String url="http://opencart.abstracta.us/index.php?route=common/home";

    By mainMyAccount = By.cssSelector("a[title='My Account']");
    By loginSelect = By.linkText("Login");
    By emailInput = By.cssSelector("#input-email");
    By passwordInput = By.cssSelector("#input-password");
    By loginButton =  By.cssSelector("input[type='submit']");

    By userAccountInner = By.xpath("//li[@class='dropdown']/ul/li");
    By newsletter = By.xpath("//a[text()='Newsletter']");
    By yesRadioButton = By.xpath("//input[@value='1']");
    By continueButton = By.xpath("//input[@value='Continue']");
    By subscribeText = By.cssSelector("div.alert.alert-success.alert-dismissible");
    By noRadioButton = By.xpath("//input[@value='0']");

    
    String expected= "Success: Your newsletter subscription has been successfully updated!";
    
    
    @BeforeTest
    void goToUrl(){

        openSite(url);
    }

    @Test (priority = -1)
    void loginWebSite(){

        clickTo(mainMyAccount);
        clickTo(loginSelect);
        sendKeysTo(emailInput,"abaleyte1@gmail.com");
        sendKeysTo(passwordInput,"Aba.kraft123");
        clickTo(loginButton);

        List<WebElement> myAccounInner = driver.findElements(userAccountInner);
        Assert.assertTrue(myAccounInner.size()>2);
    }

    @Test
    void goToNewsLetter(){

        WebElement newsletterElement = driver.findElement(newsletter);
        scrollIntoView(newsletterElement);
        clickTo(newsletter);
    }

    @Test (priority = 1)
    void subscribeAccount(){
        clickTo(yesRadioButton);
        clickTo(continueButton);

        WebElement subsText=driver.findElement(subscribeText);
        System.out.println(subsText.getText());
        Assert.assertEquals(subsText.getText(),expected);
    }

    @Test (dependsOnMethods = "subscribeAccount")
    void unSubscribeAccount(){
        goToNewsLetter();
        clickTo(noRadioButton);
        clickTo(continueButton);

        WebElement subsText=driver.findElement(subscribeText);
        Assert.assertEquals(subsText.getText(),expected);

    }



}

