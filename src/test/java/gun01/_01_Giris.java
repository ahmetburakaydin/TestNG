package gun01;

import org.testng.annotations.Test;

public class _01_Giris {
    public static void main(String[] args) {
        System.out.println("main");
    }

    int number = 10;
    {
        System.out.println("instance initializer");
    }

    public  _01_Giris () {
        System.out.println("constructor");
        System.out.println(number);
    }

    // @Test annotaionı olan classlar TestNg classlarıdır.
    // @Test annotaionı olan method ve class çalıştırılabilir.
    // bir test çalıştırıldığında o classdan bir nesne oluşturularak çalıştırılabilir.
    // @Test annotaion olan her bir method ayrı ayrı çalıştırılabilir.

    
    @Test
    void test01(){
        System.out.println("testNG-1");
    }
    
    @Test
    void test02(){
        System.out.println("testNG-2");
    }
    @Test
    void test03(){
        System.out.println("testNG-3");
    }

}
