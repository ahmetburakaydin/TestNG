package gun08.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ParentClass;

public class _02_Ornek extends ParentClass {

    String url = "https://opencart.abstracta.us/index.php?route=account/login";

    By emailInput = By.cssSelector("input#input-email");
    By passwordInput = By.cssSelector("input#input-password");
    By submit  =By.cssSelector("input[type='submit']");
    By mainMyAccount = By.cssSelector("a[title='My Account']");
    By logOutMyAccount= By.xpath(" //a[text()='Logout']");
    By hata = By.cssSelector("div.alert.alert-danger.alert-dismissible");

    @Test (dataProvider = "getData")
    public void loginTest(String username,String password, int failOrSuccess){
           driver.get(url);
           sendKeysTo(emailInput,username);
           sendKeysTo(passwordInput,password);
           clickTo(submit);
           if(failOrSuccess==0){
               Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(hata)).isDisplayed());
           }else {
               clickTo(mainMyAccount);
               Assert.assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(logOutMyAccount)).isDisplayed());
               clickTo(logOutMyAccount);
           }

    }
    @DataProvider
    public Object[][] getData (){
        Object [][] data = {

        {"hleetham0@usnews.com", "Dz7pYk", 0},
        {"mvawton1@ebay.co.uk", "P6uQ10x07pbo", 0},
        {"ijonuzi2@blogger.com", "ueQsdRg", 0},
        {"rhackley3@phpbb.com", "BrQmT8OQy3d8", 0},
        {"sbaylis4@admin.ch", "2FrLKz", 0},
         {"bdunsford5@gnu.org", "0h0Ej32", 0},
        {"dmarven6@accuweather.com", "lLIXdOlqjrR", 0},
        {"adalgarnowch7@mediafire.com", "cbZt2ZqlCvf3", 0},
        {"eneal8@drupal.org", "bwwy0aBJIJ", 0},
        {"testngkurs@gmail.com", "testngkurs", 1},
        {"cdovington9@list-manage.com", "o7CbGpxaalv", 0},
        {"bdorkena@github.com", "8AjXlD6", 0},
        {"hbendb@imdb.com", "mCdonxCK2Ix", 0},
        {"cburnhillc@stumbleupon.com", "s9KIhZYWF57", 0},
        {"dcastelaind@timesonline.co.uk", "zEWuz4URBkP", 0},
        {"lcradducke@google.co.jp", "RUIP3F", 0} ,
        };

        return data;
    }

}
