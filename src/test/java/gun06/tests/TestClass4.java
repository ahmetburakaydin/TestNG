package gun6.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestClass4 {
    WebDriver driver;

    @BeforeTest
    @Parameters("browserName")
    public void beforeTest(String browser){
        switch (browser.toLowerCase()){
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break ;
            case "edge" :
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                
        }
    }
    @Test
    public void goToUrl(){
        driver.get("https://opencart.abstracta.us/");
    }

    
    @Test (dependsOnMethods = {"goToUrl"})
    @Parameters ("searchText")
    public  void search(String txt){
         driver.findElement(By.cssSelector("input[name='search']")).sendKeys(txt);
    }

    @AfterTest
    public void quitDriver(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();

    }

}
