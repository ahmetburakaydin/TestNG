package gun03;

import org.testng.annotations.Test;

public class MenuDropDownTest extends ParentTestClass{

    @Test
    public void testMenuDropDown(){
        HomePage  testMenuDropDown = new HomePage();
        testMenuDropDown.goToWebsite();
       // testMenuDropDown.loginWebSite();
        testMenuDropDown.menuDropDownCheck();
    }
}
