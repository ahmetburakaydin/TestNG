package gun01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_Assertions {




     @Test
    void test_01(){
         int a = 2;
         int b = 3;
         Assert.assertEquals(a,b,"Sayılar eşit değil");
     }

    @Test
    void test_02(){
        int a = 2;
        int b = 3;
        Assert.assertTrue(a==b,"Sayılar eşit değil");
    }

    @Test
    void test_03(){
        int a = 2;
        int b = 2;
        Assert.assertEquals(a,b,"Sayılar eşit değil");
    }


}
