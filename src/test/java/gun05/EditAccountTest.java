package gun05;

import org.testng.annotations.Test;

public class EditAccountTest extends ParentTestClass {

    @Test
    public void testEditAccount(){

        HomePage editAccount= new HomePage();
        editAccount.goToWebsite();
        editAccount.loginWebSite();
        editAccount.editAccount("ahmet","burak");

    }
    @Test
    public void testEditAccount_2(){

        HomePage editAccount= new HomePage();
        editAccount.goToWebsite();
        editAccount.loginWebSite();
        editAccount.editAccount("aba","aba");

    }

}
