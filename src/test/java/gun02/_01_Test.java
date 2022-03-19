package gun02;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utils.Driver;

public class _01_Test {
    WebDriver driver;

    @Test
    void t1 () {
       driver= Driver.getDriver();
    }
    
    @Test
    void t2(){
         driver.get("http://wwww.google.com");

         _02_Test test2= new _02_Test();
         _03_Test test3= new _03_Test(driver);
         test2.t3();
         test3.t3();

    }

    @AfterTest
    public void aTest(){
        Driver.quitDriver();
    }
}
