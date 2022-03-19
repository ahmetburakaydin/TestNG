package gun03;

import org.testng.annotations.Test;

public class WishlistTest extends ParentTestClass{

    @Test
    public void testWishlist(){
        HomePage testWishlist = new HomePage();
        testWishlist.goToWebsite();
        testWishlist.goToProductAddWishList();
        testWishlist.loginWebSite();
        testWishlist.assertWishList();
    }
}
