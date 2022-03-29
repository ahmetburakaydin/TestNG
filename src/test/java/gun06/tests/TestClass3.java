package gun6.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestClass3 {
    @Test
    @Parameters("name")
    public void isimYaz(String name){
        System.out.println(name);
    }
}
