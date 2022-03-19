package gun02;

import org.openqa.selenium.WebDriver;
import utils.Driver;

public class _02_Test {
    WebDriver driver;

    public _02_Test(){
        this.driver= Driver.getDriver();
    }
    void t3(){
        driver.get("http://www.yahoo.com");
    }
}
