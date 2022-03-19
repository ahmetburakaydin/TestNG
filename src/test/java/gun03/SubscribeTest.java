package gun03;

import org.testng.annotations.Test;

public class SubscribeTest extends ParentTestClass{


    @Test
    public void testSubscribe(){

        HomePage testSubscribe = new HomePage();
        testSubscribe.goToWebsite();
        testSubscribe.loginWebSite();
        testSubscribe.goToNewsletter();
        testSubscribe.subscribeAccount();
        testSubscribe.logOut();

    }


}
