package baseTest;


import com.sun.net.httpserver.Authenticator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginTest extends BaseTests {

    //login with credentials
    @Test(priority = 1)
    public void loginSuccessfulTest() {

        //login functionality
        LoginPage loginTest = homePage.clickFormAuthenticationLink();
        loginTest.setUsername("tomsmith");
        loginTest.setPassword("SuperSecretPassword!");


        SecureAreaPage secureAreaPage = loginTest.clickSubmitButton();
        Assert.assertTrue(secureAreaPage._getFlashMessage().contains("You logged into a secure area!"));

        LoginPage logoutPage = secureAreaPage.clickLogoutButton();
        Assert.assertTrue(logoutPage.getFlashMessage().contains("You logged out of the secure area!"));
    }


    @Test(priority = 1,dataProvider = "LoginData")
    public void loginSuccessfulTest(String Username, String Password, boolean Success) {

        //login functionality
        LoginPage loginTest = homePage.clickFormAuthenticationLink();
        loginTest.setUsername(Username);
        loginTest.setPassword(Password);

        SecureAreaPage secureAreaPage = loginTest.clickSubmitButton();
        Assert.assertTrue(Success,secureAreaPage._getFlashMessage());

        /*click logout button
        SecureAreaPage secureAreaPage1 = new SecureAreaPage(driver);
        secureAreaPage.clickLogoutButton();

        String loginPage = "https://the-internet.herokuapp.com/login";
        String currentPage = driver.getCurrentUrl();
        Assert.assertEquals(loginPage,currentPage);
    }
         */

    }

    //Provides data
    @DataProvider()
    public Object[][] LoginData(){
        Object[][] data = new Object[2][3];

        data[0][0] = "tomsmith"; data[0][1] = "SuperSecretPassword"; data[0][2] = true;
        data[1][0] = "tomsmith2"; data[1][1] = "SuperSecretPassword!2"; data[1][2] = false;

        return data;
    }

}
