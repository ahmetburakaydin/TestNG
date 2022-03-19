package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {
   private static WebDriver driver;
   private  static WebDriverWait wait;
   
   public static WebDriver getDriver() {
      if(driver==null){
         WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
         driver.manage().window().maximize();
      }
      return driver;
   }

   public static WebDriver getDriver(Browsers browser) {
      if(driver==null) {
         switch (browser) {
            case CHROME -> {
               WebDriverManager.chromedriver().setup();
               ChromeOptions options=new ChromeOptions();
               options.addArguments("start-maximized");
               driver=new ChromeDriver();
            }
            case FIREFOX -> {
               WebDriverManager.firefoxdriver().setup();
               driver=new FirefoxDriver();
               driver.manage().window().maximize();
            }
         }

      }
      return driver;
   }


   public static void quitDriver(){
      if(driver!=null){
         driver.quit();
         driver=null;
      }
   }
}
