package gun6.tests;

import org.testng.annotations.Test;

public class TestClass2 {

    @Test (groups = {"TestGroup1","TestGroup3"})
    public void test4(){
        System.out.println("test4");
    }
    @Test (groups = {"TestGrou2"})
    public void test5(){
        System.out.println("test5");
    }
    @Test (groups = {"TestGroup1","TestGroup2"})
    public void test6(){
        System.out.println("test6");
    }
}
