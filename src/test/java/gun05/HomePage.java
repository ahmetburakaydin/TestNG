package gun05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.ParentClass;

import java.util.List;

public class HomePage extends ParentClass {

       String url="http://opencart.abstracta.us/index.php?route=common/home";
       By mainMyAccount = By.cssSelector("a[title='My Account']");
       By loginMyAccount = By.linkText("Login");
       By emailInput = By.cssSelector("#input-email");
       By passwordInput = By.cssSelector("#input-password");
       By loginButton =  By.cssSelector("input[type='submit']");
       By userMyAccountMenu = By.xpath("//li[@class='dropdown']/ul/li");


       By editAccount = By.xpath("//a[text()='Edit Account']");
       By username = By.cssSelector("input#input-firstname");
       By lastname = By.cssSelector("input#input-lastname");
       By submitCont= By.cssSelector("input.btn.btn-primary");

       String expectedEdit = "successfully";
       By editAccountText = By.cssSelector("div[class='alert alert-success alert-dismissible']");
       public void goToWebsite(){

              openSite(url);
       }

       public void loginWebSite(){

              clickTo(mainMyAccount);
              clickTo(loginMyAccount);
              sendKeysTo(emailInput,"abaleyte1@gmail.com");
              sendKeysTo(passwordInput,"Aba.kraft123");
              clickTo(loginButton);

              List<WebElement> myAccounInner = driver.findElements(userMyAccountMenu);
              Assert.assertTrue(myAccounInner.size()>2);
              System.out.println("Successfully Login!");
       }

       public void editAccount(String username1,String lastname1){
              clickTo(editAccount);
              
              clear(driver.findElement(username));
              sendKeysTo(username,username1);

              clear(driver.findElement(lastname));
              sendKeysTo(lastname,lastname1);

              clickTo(submitCont);

              verifyNotification(editAccountText,expectedEdit);

       }

       public void verifyNotification(By locater,String str){
              WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locater)) ;

              Assert.assertTrue(driver.findElement(locater).getText().contains(str));
       }
    
}
