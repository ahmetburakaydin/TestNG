package gun03;

import org.testng.annotations.Test;

public class MenuTextsTest extends ParentTestClass{

    @Test
    public void testMenuTexts (){
        HomePage testMenuTexts = new HomePage();
        testMenuTexts.goToWebsite();
        //testMenuTexts.loginWebSite();
        testMenuTexts.menuTextsCheck();
    }

}
