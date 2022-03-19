package gun03;

import org.testng.annotations.Test;

public class LogoutTest {

    @Test
    public void testLogout () {
        HomePage  testLogout= new HomePage() ;
        testLogout.goToWebsite();
        testLogout.loginWebSite();
        testLogout.logOut();
    }
}
