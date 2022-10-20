package baseTest;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.SecureAreaPage;

public class ForgotPwdTest extends BaseTests {

    @Test(priority = 2)
    public void forgotPwdTest(){
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPwd("Forgot Password");
        forgotPasswordPage.enterEmail("Just@do.it");
        forgotPasswordPage.clickRetrievePwdButton();
        Assert.assertEquals(forgotPasswordPage.getErrorMsg(),"Internal Server Error");
    }

    @DataProvider()
    public Object[][] ForgotPasswordData(){
        Object[][] data = new Object[4][3];

        data[0][0] = "test@gmail.com"; data[0][1] = "Inspired@testing.com"; data[0][2] = true;
        data[1][0] = "Automate@123.com"; data[1][1] = "Test@password.com"; data[1][2] = true;
        data[2][0] = "Automate@123.com**"; data[2][1] = "Test@password.com**"; data[2][2] = false;
        data[3][0] = "Automate@123.com()"; data[3][1] = "Test@password.com()"; data[3][2] = false;

        return data;
    }

}
