package gun01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class _06_Ornek {
    /*
    @BeforeClassda
        driver tanımlayın
     @Test
            siteye gidin    title assert edin
      @Test
      login olun ve olduğunuzu assert edin

      AfterClass'da d
            driverı kapatın

     */
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void getDriver (){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
    }
    @Test
    public void testTitle (){
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        String title = driver.getTitle();
        String expected = "OrangeHRM";
        Assert.assertEquals(title,expected,"Başlık Doğrulama Başarısız");
    }

    @Test (dependsOnMethods = "testTitle")
    void testLogin(){
        driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");

        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("admin123");

        driver.findElement(By.cssSelector("input#btnLogin")).click();

        WebElement welcome = driver.findElement(By.cssSelector("a.panelTrigger"));
        Assert.assertTrue(welcome.getText().contains("Welcome"),"Login Islemi Basarısız");
        
    }
    @AfterClass
    void quitDriver(){
        driver.quit();
    }
}
