package gun02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Driver;
import utils.ParentClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _04_Ornek extends ParentClass {

    String url="http://opencart.abstracta.us/index.php?route=common/home";

    By lSearchInput = By.cssSelector("div#search input");
    By lSearchButton= By.cssSelector(".input-group-btn button");
    By ldesktop = By.xpath("//a[text()='Desktops']");
    By lallDesktop = By.xpath("//a[text()='Show All Desktops']");


    @Test
    void menuList(){
       openSite(url);

       sendKeysTo(lSearchInput,"mac");

       clickTo(lSearchButton);
    }

   /* @Test (dependsOnMethods ="menuList" )
    void checkMenu() throws InterruptedException {
        hoverAction(driver.findElement(lallDesktop));

        String expected = "Show All Desktops";

        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(lallDesktop)).getText();

        Assert.assertEquals(actual,expected);
    }
*/
  /*  @Test (dependsOnMethods ="checkMenu" )
    void hoverMenuList(){

        List<WebElement> menuList =driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li"));

        List<String> menuTextList = new LinkedList<>();


        for (int i = 0; i < menuList.size(); i++) {
            Actions builder=new Actions(driver);
            wait.until(ExpectedConditions.visibilityOf(menuList.get(i)));
            builder.moveToElement(menuList.get(i)).pause(Duration.ofSeconds(1)).build().perform();


        }

    }*/

}
