package gun03;

import org.testng.annotations.Test;

public class UnsubscribeTest {

    @Test
    public void unsubscribeTest(){
        HomePage testSubscribe = new HomePage();
        testSubscribe.goToWebsite();
        testSubscribe.loginWebSite();
        testSubscribe.goToNewsletter();
        testSubscribe.unSubscribeAccount();
        testSubscribe.logOut();
    }

}
