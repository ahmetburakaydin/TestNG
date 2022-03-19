package gun02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ParentClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _05_Ornek extends ParentClass {

    String url="http://opencart.abstracta.us/index.php?route=common/home";


    @BeforeTest
    void goToUrl(){
        openSite(url);
    }

    @Test
    void checkMenuText(){
        List<WebElement> menuList= driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li"));

        List<String> expectedList=new LinkedList<>();

        expectedList.add("Show All Desktops");
        expectedList.add("Show All Laptops & Notebooks");
        expectedList.add("Show All Components");
        expectedList.add("Show All MP3 Players");

        List<String> menuText= new LinkedList<>();
        for (WebElement element : menuList) {
            hoverAction(element,Duration.ofSeconds(1));

            if (element.getText().contains("Show All")) {
                menuText.add(element.getText());
            }
        }

        for (int i = 0; i < menuText.size(); i++) {
            Assert.assertTrue(menuText.get(i).contains(expectedList.get(i)));
            System.out.println((i+1)+". Assertion Islemi Başarılı!");
        }
     
    }

}

