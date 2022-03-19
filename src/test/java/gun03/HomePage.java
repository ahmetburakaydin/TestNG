package gun03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.ParentClass;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

public class HomePage extends ParentClass {

    String url="http://opencart.abstracta.us/index.php?route=common/home";

    By mainMyAccount = By.cssSelector("a[title='My Account']");
    By loginMyAccount = By.linkText("Login");
    By emailInput = By.cssSelector("#input-email");
    By passwordInput = By.cssSelector("#input-password");
    By loginButton =  By.cssSelector("input[type='submit']");

    By userMyAccountMenu = By.xpath("//li[@class='dropdown']/ul/li");
    By logOutMyAccount= By.xpath(" //a[text()='Logout']");
    By logOutText = By.cssSelector("div#content");
    String expectedLogOut ="logged off";

    By newsletter = By.xpath("//a[text()='Newsletter']");
    By yesRadioButton = By.xpath("//input[@value='1']");
    By noRadioButton = By.xpath("//input[@value='0']");
    By continueButton = By.xpath("//input[@value='Continue']");
    By subscribeText = By.cssSelector("div.alert.alert-success.alert-dismissible");
    String expectedText = "successfully";

    By menuBar =By.xpath("//ul[@class='nav navbar-nav']/li");
    By dropDownInner= By.cssSelector(".dropdown-inner");
    By dropDownInnerLine= By.cssSelector("div.dropdown-inner li");

    By lSearchInput = By.cssSelector("div#search input");
    By lSearchButton= By.cssSelector(".input-group-btn button");
    By searchResult = By.cssSelector("div.image a img");

    By components = By.xpath("//a[text()='Components']");
    By monitors = By.xpath("//a[contains(text(),'Monitors')]");
    By productListInner = By.cssSelector("div.image a");
    By addToWishList = By.xpath("//button[contains(@onclick,'wishlist')]");

    By wishListTopMenu = By.xpath("//a[contains(@title,'Wish List')]");
    String expectedRemoveText="empty";
    By removeWishListText = By.cssSelector("div#content p");

    public void goToWebsite(){

        openSite(url);
    }

    public void loginWebSite(){

        clickTo(mainMyAccount);
        clickTo(loginMyAccount);
        sendKeysTo(emailInput,"abaleyte1@gmail.com");
        sendKeysTo(passwordInput,"Aba.kraft123");
        clickTo(loginButton);

        List<WebElement> myAccounInner = driver.findElements(userMyAccountMenu);
        Assert.assertTrue(myAccounInner.size()>2);
        System.out.println("Successfully Login!");
    }
    public void logOut(){
         clickTo(mainMyAccount);
         if(driver.findElement(mainMyAccount).findElement(logOutMyAccount).isDisplayed()){
             clickTo(logOutMyAccount);
             clickTo(mainMyAccount);
             Assert.assertTrue(wait.until(ExpectedConditions
                     .visibilityOfElementLocated(logOutText))
                     .getText().contains(expectedLogOut));
             System.out.println("Logging Out!");
         }

    }

    public void searchText (String text){
        sendKeysTo(lSearchInput,text);

        clickTo(lSearchButton);
    }

    public void justifySearchText(String text){
        List<WebElement> productList= driver.findElements(searchResult);

        List<String> productNameList=new LinkedList<>();

        for (WebElement element : productList) {
            productNameList.add(element.getAttribute("title"));
        }
        System.out.println(productNameList);
        for (String s : productNameList) {
             Assert.assertTrue(s.toLowerCase().contains(text.toLowerCase()));
        }

    System.out.println("Aranan Kelime '"+text+"' arama sonuclarında doğrulandı!");

    }

    public void goToProductAddWishList(){
        hoverAction(components);
        clickTo(monitors);

        List<WebElement> listProduct = driver.findElements(productListInner);

        WebElement random = getRandomWebElement(listProduct);

        clickTo(random.findElement(addToWishList));

    }

    public void assertWishList(){
          clickTo(wishListTopMenu);
          List<WebElement> wishListInner = driver.findElements(By.cssSelector("table tbody tr"));
          System.out.println(wishListInner.size());
          Assert.assertTrue(wishListInner.size()>0);
    }

    public void clearWishList(){
        clickTo(wishListTopMenu);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement removerIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("btn btn-danger")));
        clickTo(removerIcon);
        System.out.println(driver.findElement(removeWishListText).getText());
        Assert.assertTrue(driver.findElement(removeWishListText).getText().toLowerCase()
                          .contains(expectedRemoveText.toLowerCase()));

        openSite(url);
    }


    public void goToNewsletter (){
        WebElement newsletterElement = driver.findElement(newsletter);
        scrollIntoView(newsletterElement);
        clickTo(newsletter);
    }

    public void subscribeAccount(){

        clickTo(yesRadioButton);
        clickTo(continueButton);
        WebElement subsText=driver.findElement(subscribeText);
        Assert.assertTrue(subsText.getText().contains(expectedText));
        System.out.println("Your subscription has been successfully described");

    }

    public void unSubscribeAccount(){

        goToNewsletter();
        clickTo(noRadioButton);
        clickTo(continueButton);
        WebElement subsText=driver.findElement(subscribeText);
        Assert.assertTrue(subsText.getText().contains(expectedText));
        System.out.println("Your subscription has been successfully undescribed");

    }

    public void menuTextsCheck(){
        List<WebElement> menuList = driver.findElements(menuBar);

        List<String> menuTextList = new LinkedList<>();
        for (WebElement e : menuList) {
           menuTextList.add(e.getText());
        }

        for (int i = 0; i < menuList.size(); i++) {
            Assert.assertEquals(menuList.get(i).getText(),menuTextList.get(i));
        }
        System.out.println("Menu-Checking is Over");

    }

    public void menuDropDownCheck(){
        List<WebElement> menuList = driver.findElements(menuBar);

        for (WebElement element : menuList) {
            hoverAction(element, Duration.ofSeconds(1));
            if(element.findElements(dropDownInner).size()>0){
                System.out.println("Alt Menu Var "+ element.findElements(dropDownInnerLine).size());
                Assert.assertTrue(element.findElement(dropDownInner).isDisplayed());
            }
            else System.out.println("Alt Menu YOK !");

        }
    }

    


}
