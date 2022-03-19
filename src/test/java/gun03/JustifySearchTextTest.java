package gun03;

import org.testng.annotations.Test;

public class JustifySearchTextTest extends ParentTestClass{

    @Test
    public void testSearchText() {
        HomePage testSearchText = new HomePage();
        testSearchText.goToWebsite();
        String text = "mac";
        testSearchText.searchText(text);
        testSearchText.justifySearchText(text);
        
    }
}
