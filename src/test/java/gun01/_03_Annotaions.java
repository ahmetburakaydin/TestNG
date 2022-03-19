package gun01;

import org.testng.annotations.*;

public class _03_Annotaions {

    @Test
    void test01(){
        System.out.println("test01");
    }
    @Test
    void test02(){
        System.out.println("test02");
    }

    @BeforeTest
    void beforeTest(){
        System.out.println("beforeTest");
    }

    @AfterTest
    void  afterTest(){
        System.out.println("AfterTest");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass");
    }
    @AfterClass
    private void afterClass() {
        System.out.println("afterClass");
    }

    @BeforeSuite
    void beforeSuite(){
        System.out.println("BeforeSuite");
    }

    @AfterSuite
    void afterSuite(){
        System.out.println("AfterSuite");
    }

    

}
