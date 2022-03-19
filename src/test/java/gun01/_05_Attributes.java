package gun01;

import org.testng.annotations.Test;

public class _05_Attributes {

    /**
     * priority , öncelik -5000,5000 arasnda olabilir.
     * priority yazılmaz ise default olarak 0'dır.
     * priority'si aynı olan test methodlarını isim sıralamasına göre çalıştır
     *  test_01 > test_03 > test_05
     */

    @Test(testName = "5 nolu Test", priority =-1)
    public void test_05(){
        System.out.println("test_05");
    }
    // enable attribute u methodun calistirilip çalıştırılmayacağını belirler
    @Test (testName = "1 nolu Test",enabled = false)
    public void test_03(){
        System.out.println("test_01");
    }
    @Test(testName = "3 nolu Test",timeOut = 2000)
    public void test_01(){
        System.out.println("test_03");
    }
    // testin ne kadar süreceğini sınırlar 
    @Test(testName = "3 nolu Test",timeOut = 2000)
    public void test_04(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test_04");
    }
    // testin kaç kere tekrarlacağını belirler. 5 defa tekrarlar bu örnekte
    @Test(testName = "6 nolu Test",invocationCount = 5)
    public void test_06(){
        System.out.println("test_06");
    }
}
