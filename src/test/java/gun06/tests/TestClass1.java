package gun6.tests;

import org.testng.annotations.Test;

public class TestClass1 {


    @Test (groups = {"TestGroup1"})
    public void test1(){
        System.out.println("test1");
    }
    @Test (groups = {"TestGroup1","TestGroup2"})
    public void test2(){
        System.out.println("test2");
    }
    @Test (groups = {"TestGroup2","TestGroup3"})
    public void test3(){
        System.out.println("test3");
    }

}
