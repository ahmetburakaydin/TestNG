package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ParentClass {
    public WebDriver driver;
    public WebDriverWait wait;
    
    public ParentClass(){
          driver=Driver.getDriver();
          wait= new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    public void openSite(String url){

        driver.get(url);
    }

    public void clickTo(By locater){

        wait.until(ExpectedConditions.elementToBeClickable(locater)).click();
    }
    public void clickTo(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendKeysTo(By locater,String txt){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locater)).sendKeys(txt);
    }

   public void hoverAction(WebElement element , Duration duration)  {
       new Actions(driver).moveToElement(element).pause(Duration.ofSeconds(1)).build().perform();

   }
   public void hoverAction(WebElement element){

        hoverAction(element,Duration.ofSeconds(1));
   }
   public  void hoverAction(By locater){
        new Actions(driver).moveToElement(driver.findElement(locater)).build().perform();
   }
   public void scrollIntoView(WebElement element){
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView(true);",element);
   }

   public WebElement  getRandomWebElement(List<WebElement> list){
        return list.get(new Random().nextInt(list.size()));
   }
   public void clear(WebElement element){
        element.clear();
   }

    
}
