package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private final WebDriver driver;
    private By forgotPwdEmail = By.id("email");

    private By retrievePwd = By.cssSelector("#form_submit > i");
    private By errorMsg = By.tagName("h1");

    //creating a constructor
    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterEmail(String email){
        driver.findElement(forgotPwdEmail).sendKeys(email);
    }

    public void clickRetrievePwdButton(){
        driver.findElement(retrievePwd).submit();
    }

    public String getErrorMsg(){
       return driver.findElement(errorMsg).getText();
    }
}


