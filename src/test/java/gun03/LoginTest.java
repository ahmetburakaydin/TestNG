package gun03;

import org.testng.annotations.Test;

public class LoginTest extends ParentTestClass{

    @Test
    public void testLogin(){
        HomePage  testLogin = new HomePage() ;
        testLogin.goToWebsite();
        testLogin.loginWebSite();
    }

}
