package gun03;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import utils.Driver;

public class ParentTestClass {

    @AfterMethod
    public void quitDriver(){
        Driver.quitDriver();
    }

    @AfterTest
    public void quitDriver2(){
        Driver.quitDriver();
    }
}
