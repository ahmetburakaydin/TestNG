package gun02;

import org.openqa.selenium.WebDriver;

public class _03_Test {
    WebDriver driver;

    public  _03_Test (WebDriver driver){
        this.driver=driver;
    }

    void t3(){
        driver.get("http://www.amazon.com");
    }
}
