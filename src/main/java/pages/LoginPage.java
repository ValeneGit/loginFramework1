package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By username = By.id("username");
    private By password = By.id("password");

    private By submitButton = By.cssSelector("#login button");

    private By flash_messages = By.id("flash");

    //constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public String getFlashMessage() {
        return driver.findElement(flash_messages).getText();
    }

    //input username method
    public void setUsername(String inputName) {
        driver.findElement(username).sendKeys(inputName);
    }

       //input password method
        public void setPassword(String inputPassword){
            driver.findElement(password).sendKeys(inputPassword);
    }

    //clicking on the login button
    public SecureAreaPage clickSubmitButton(){
        driver.findElement(submitButton).click();
        return new SecureAreaPage(driver);
    }

}

